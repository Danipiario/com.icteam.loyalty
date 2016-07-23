package com.icteam.loyalty.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.icteam.loyalty.model.interfaces.IHierarchyTemplate;

public abstract class AbstractHierarchyService<H extends HierarchyDtoModel<H>> implements HierarchyService<H> {

    private EntityManager entityManager;

    private ModelService modelService;

    public EntityManager getEntityManager() {
        if (entityManager == null) {
            throw new IllegalArgumentException("EntityManager not initialized - please insert into blueprint configuration");
        }

        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ModelService getModelService() {
        if (modelService == null) {
            throw new IllegalArgumentException("Service not initialized - please insert into blueprint configuration");
        }

        return modelService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    public abstract ModelBuilder<H> getHierarchyModelBuilder();

    @Override
    public <T extends DbModel<H>, HT extends IHierarchyTemplate<T>> List<H> search(HT template) {
        List<T> dbModels = modelService.search(entityManager, template);

        return getHierarchyModelBuilder().buildDtoList(dbModels);
    }

    @Override
    public <T extends DbModel<H>, HT extends IHierarchyTemplate<T>> boolean link(H parent, H child, Class<HT> templateClass) {
        if (child == null || child.equals(parent) || hasRelation(child, parent, templateClass) || isParent(parent, child, templateClass)) {
            return false;
        }

        Query query = entityManager.createNativeQuery("INSERT INTO " + parent.getHierarchyTable() + " (K_PARENT, K_CHILD) VALUES (?1, ?2)");
        query.setParameter(1, parent.getId());
        query.setParameter(2, child.getId());

        query.executeUpdate();

        if (parent.getChildrenDto().isEmpty()) {
            parent.getChildrenDto().add(createDtoPlaceholder());
        } else {
            parent.getChildrenDto().add(child);
        }

        parent.setHasChildren(null);

        return true;
    }

    @Override
    public <T extends DbModel<H>, HT extends IHierarchyTemplate<T>> void unlink(H parent, H child) {
        if (child != null && parent != null) {
            Query query = entityManager.createNativeQuery("DELETE FROM " + parent.getHierarchyTable() + " WHERE K_PARENT = ?1 AND K_CHILD = ?2");
            query.setParameter(1, parent.getId());
            query.setParameter(2, child.getId());

            if (query.executeUpdate() > 0) {
                parent.getChildrenDto().remove(child);
                parent.setHasChildren(null);
            }
        }
    }

    @Override
    public <T extends DbModel<H>, HT extends IHierarchyTemplate<T>> boolean isOrphan(H hierarchyDto, Class<HT> templateClass) {
        T dbModel = getHierarchyModelBuilder().build(hierarchyDto);

        HT template = buildTemplate(templateClass);
        template.setChild(dbModel);

        List<H> list = search(template);
        if (list.size() == 0) {
            template.setParent(dbModel);

            list = search(template);
            return list.size() == 0;
        }

        return false;
    }

    @Override
    public <T extends DbModel<H>, HT extends IHierarchyTemplate<T>> boolean hasParents(H hierarchyDto, Class<HT> templateClass) {
        HT template = buildTemplate(templateClass);
        template.setChild(getHierarchyModelBuilder().build(hierarchyDto));

        List<H> list = search(template);

        return list.size() > 0;
    }

    @Override
    public <T extends DbModel<H>, HT extends IHierarchyTemplate<T>> boolean hasChildren(H hierarchyDto, Class<HT> templateClass) {
        HT template = buildTemplate(templateClass);
        template.setParent(getHierarchyModelBuilder().build(hierarchyDto));

        List<H> list = search(template);

        return list.size() > 0;
    }

    @Override
    public <T extends DbModel<H>, HT extends IHierarchyTemplate<T>> boolean isParent(H parent, H child, Class<HT> templateClass) {
        if (parent.equals(child)) {
            return true;
        }

        HT template = buildTemplate(templateClass);
        template.setChild(getHierarchyModelBuilder().build(child));

        List<H> parents = search(template);
        return parents.contains(parent);
    }

    @Override
    public <T extends DbModel<H>, HT extends IHierarchyTemplate<T>> boolean hasRelation(H parent, H child, Class<HT> templateClass) {
        if (parent.equals(child)) {
            return true;
        }

        HT template = buildTemplate(templateClass);

        template.setChild(getHierarchyModelBuilder().build(child));

        List<H> parents = search(template);
        for (H hierarchyDto : parents) {
            if (hasRelation(parent, hierarchyDto, templateClass)) {
                return true;
            }
        }

        return false;
    }

    private static <HT extends IHierarchyTemplate<T>, T extends DbModel< ? >> HT buildTemplate(Class<HT> templateClass) {
        try {
            HT template = templateClass.newInstance();
            template.setHierarchySearch(true);

            return template;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();

            // nothing to do
            return null;
        }
    }

    private H createDtoPlaceholder() {
        return getHierarchyModelBuilder().newDto();
    }
}
