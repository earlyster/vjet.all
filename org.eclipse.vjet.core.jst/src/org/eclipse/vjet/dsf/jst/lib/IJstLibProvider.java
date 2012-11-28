/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jst.lib;

import java.util.List;
import org.eclipse.vjet.dsf.jst.IJstLib;

public interface IJstLibProvider {
	List<IJstLib> getAll();
	IJstLibProvider add(IJstLib jstLib);
	IJstLib remove(String lib);
	void clearAll();
}
