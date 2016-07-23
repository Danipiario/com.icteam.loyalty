package com.icteam.loyalty.ui.internal;

/*******************************************************************************
 * Copyright (c) 2008 Tom Schindl and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl - initial API and implementation
 ******************************************************************************/
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Snippet {

    /**
     * Snippet to demonstrate multi-selection support added in 3.4
     */
    public Snippet(Shell shell) {
    }

    public static void run(final Display display) {
//        Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
//            @Override
//            public void run() {
//                final Shell shell = new Shell(display);
//                new Snippet(shell);
//                shell.open();
//                while (!shell.isDisposed()) {
//                    if (!display.readAndDispatch()) {
//                        display.sleep();
//                    }
//                }
//            }
//        });
    }
}
