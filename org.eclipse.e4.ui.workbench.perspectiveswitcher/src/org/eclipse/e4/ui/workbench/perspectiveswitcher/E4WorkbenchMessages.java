/*******************************************************************************
 * Copyright (c) 2012 Joseph Carroll and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Joseph Carroll <jdsalingerjr@gmail.com> - initial API and implementation
 ******************************************************************************/
package org.eclipse.e4.ui.workbench.perspectiveswitcher;

import com.icteam.loyalty.common.nls.NLS;

public class E4WorkbenchMessages {

	public String openSelectPerspectiveWindow;
	public String selectPerspectiveWindow;
	public String active;

	public static E4WorkbenchMessages get() {
		return NLS.getUTF8Encoded(E4WorkbenchMessages.class);
	}
}
