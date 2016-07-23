package com.icteam.loyalty.ui.model;

import java.lang.ref.WeakReference;
import java.util.List;

import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.internal.expressions.ReferenceExpression;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.IEvaluationService;

import com.icteam.loyalty.model.interfaces.IDtoModel;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.interfaces.IDtoEditorInput;
import com.icteam.loyalty.ui.interfaces.IVirtualView;

public class DtoEditorInput<D extends IDtoModel> implements IDtoEditorInput<D> {

    private D dto;
    D internalDto;
    private WeakReference<IVirtualView< ? , D>> virtualViewRef;
    private final String editorID;
    private boolean cloned = true;

    public DtoEditorInput(D internalDto) {
        this(internalDto, null);
    }

    public DtoEditorInput(D internalDto, IVirtualView< ? , D> virtualView, String editorID) {
        this.internalDto = internalDto;

        this.dto = (D) ModelUtil.clone(internalDto);
        this.editorID = editorID;

        this.virtualViewRef = new WeakReference<IVirtualView< ? , D>>(virtualView);

        updateEditableState();
    }

    public DtoEditorInput(D internalDto, String editorID) {
        this.internalDto = internalDto;

        this.dto = internalDto;
        this.editorID = editorID;

        cloned = false;

        updateEditableState();
    }

    private void updateEditableState() {
        dto.setEditable(false);

        if (editorID != null) {
            IEvaluationService es = (IEvaluationService) PlatformUI.getWorkbench().getService(IEvaluationService.class);
            IEvaluationContext currentState = es.getCurrentState();

            ReferenceExpression referenceExpression = new ReferenceExpression(editorID);
            try {
                EvaluationResult result = referenceExpression.evaluate(currentState);
                dto.setEditable(EvaluationResult.TRUE.equals(result));
            } catch (CoreException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public D getDto() {
        return dto;
    }

    @Override
    public void setDto(D dto) {
        if (this.dto != null && this.dto != dto) {
            dto.copyTo(this.dto);
        }

        if (cloned) {
            this.dto.copyTo(internalDto);
        } else {
            this.internalDto = dto;
        }

        final IVirtualView< ? , D> virtualView = getVirtualView();

        if (virtualView != null && virtualView.getColumnViewer().getInput() instanceof List) {
            if (!virtualView.getViewInput().contains(internalDto)) {
                virtualView.reload(false);

                Display.getCurrent().timerExec(100, new Runnable() {
                    @Override
                    public void run() {
                        for (D item : virtualView.getViewInput()) {
                            if (item.equals(internalDto)) {
                                internalDto = item;
                                break;
                            }
                        }
                    }
                });
            }
        }

        updateEditableState();
    }

    // check null ref
    private IVirtualView< ? , D> getVirtualView() {
        return virtualViewRef != null ? virtualViewRef.get() : null;
    }

    @Override
    public Object getAdapter(Class adapter) {
        return null;
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return null;
    }

    @Override
    public String getName() {
        return dto.getClass().getName();
    }

    @Override
    public IPersistableElement getPersistable() {
        return null;
    }

    @Override
    public String getToolTipText() {
        return dto.getTootlTipText();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (internalDto == null ? 0 : internalDto.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DtoEditorInput<D> other = (DtoEditorInput<D>) obj;
        if (internalDto == null) {
            if (other.internalDto != null) {
                return false;
            }
        } else if (!internalDto.equals(other.internalDto)) {
            return false;
        }
        return true;
    }

}
