package com.icteam.loyalty.model;

import java.util.List;

import com.icteam.loyalty.model.interfaces.IHierarchyTemplate;

public interface HierarchyService<H extends HierarchyDtoModel<H>> {

    <T extends DbModel<H>, HT extends IHierarchyTemplate<T>> boolean link(H parent, H child, Class<HT> templateClass);

    <T extends DbModel<H>, HT extends IHierarchyTemplate<T>> boolean hasRelation(H parent, H child, Class<HT> templateClass);

    <T extends DbModel<H>, HT extends IHierarchyTemplate<T>> boolean isParent(H parent, H child, Class<HT> templateClass);

    <T extends DbModel<H>, HT extends IHierarchyTemplate<T>> void unlink(H parent, H child);

    <T extends DbModel<H>, HT extends IHierarchyTemplate<T>> boolean isOrphan(H hierarchyDto, Class<HT> templateClass);

    <T extends DbModel<H>, HT extends IHierarchyTemplate<T>> boolean hasParents(H hierarchyDto, Class<HT> templateClass);

    <T extends DbModel<H>, HT extends IHierarchyTemplate<T>> boolean hasChildren(H hierarchyDto, Class<HT> templateClass);

    <T extends DbModel<H>, HT extends IHierarchyTemplate<T>> List<H> search(HT template);
}
