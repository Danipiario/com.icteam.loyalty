package com.icteam.loyalty.ui.dialog;

import org.eclipse.emf.common.ui.DiagnosticComposite;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

public class MultiLineDiagnosticDialog extends DiagnosticDialog {
    private final Diagnostic diagnostic;

    public static int openProblem(Shell parent, String dialogTitle, String message, Diagnostic diagnostic) {
        return open(parent, dialogTitle, message, diagnostic, DiagnosticComposite.ERROR_WARNING_MASK);
    }

    public static int open(Shell parentShell, String title, String message, Diagnostic diagnostic, int displayMask) {
        DiagnosticDialog dialog = new MultiLineDiagnosticDialog(parentShell, title, message, diagnostic, displayMask);
        return dialog.open();
    }

    public MultiLineDiagnosticDialog(Shell parentShell, String dialogTitle, String message, Diagnostic diagnostic, int severityMask) {
        super(parentShell, dialogTitle, message, diagnostic, severityMask);
        this.diagnostic = diagnostic;
    }

    @Override
    protected DiagnosticComposite createDiagnosticComposite(Composite parent) {
        DiagnosticComposite diagnosticComposite = super.createDiagnosticComposite(parent);
        Tree tree = (Tree) ((SashForm) diagnosticComposite.getChildren()[0]).getChildren()[0];
        tree.setData(RWT.MARKUP_ENABLED, Boolean.TRUE);
        int maxMessageRow = computeMaxMessageRow(diagnostic, 1);
        tree.setData(RWT.CUSTOM_ITEM_HEIGHT, tree.getItemHeight() * maxMessageRow);

        return diagnosticComposite;
    }

    private int computeMaxMessageRow(Diagnostic diagnostic, int maxMessageRow) {
        String[] lines = diagnostic.getMessage().split("<br/>");

        maxMessageRow = Math.max(maxMessageRow, lines.length);

        for (Diagnostic child : diagnostic.getChildren()) {
            maxMessageRow = computeMaxMessageRow(child, maxMessageRow);
        }

        return maxMessageRow;
    }
}
