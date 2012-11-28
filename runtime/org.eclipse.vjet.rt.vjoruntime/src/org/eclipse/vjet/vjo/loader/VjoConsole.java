/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.vjo.loader;

import java.io.PrintStream;

import org.eclipse.vjet.dsf.dap.rt.BaseScriptable;
import org.mozilla.mod.javascript.Context;
import org.mozilla.mod.javascript.NativeJavaObject;
import org.mozilla.mod.javascript.Scriptable;
import org.mozilla.mod.javascript.ScriptableObject;
import org.mozilla.mod.javascript.StackInspector;
import org.mozilla.mod.javascript.Undefined;
import org.mozilla.mod.javascript.StackInspector.StackInfo;

/**
 * An adapter class in server side for vjo.sysout and vjo.syserr
 */
public class VjoConsole extends BaseScriptable {
	
	private static final long serialVersionUID = 1L;
	private static final String[] MTD_NAMES = {"print", "println", "printStackTrace"};
	private static final String VJO_INSTANCE = "vjo";
	private static final String VJO_SYSOUT_PROP = "sysout";
	private static final String VJO_SYSERR_PROP = "syserr";
	
	private final PrintStream m_ps;
	
	public static void enable(Context cx, Scriptable scope) {
		VjoConsole out = new VjoConsole(false);
		Object scriptOut = Context.javaToJS(out, scope);
		Scriptable vjo = (Scriptable)ScriptableObject.getProperty(scope, VJO_INSTANCE);
		ScriptableObject.putProperty(vjo, VJO_SYSOUT_PROP, scriptOut);
		VjoConsole err = new VjoConsole(true);
		Object scriptErr = Context.javaToJS(err, scope);
		ScriptableObject.putProperty(vjo, VJO_SYSERR_PROP, scriptErr);
	}
	
	public VjoConsole(boolean err) {
		if (err) {
			m_ps = System.err;
		}
		else {
			m_ps = System.out;
		}
		defineFunctionProperties(MTD_NAMES);
	}
	
	public void print(Object o0, Object o1, Object o2, Object o3, Object o4,
			Object o5, Object o6, Object o7, Object o8, Object o9) {
		internalPrint(o0, o1, o2, o3, o4, o5, o6, o7, o8, o9);
	}
	
	public void println(Object o0, Object o1, Object o2, Object o3, Object o4,
		Object o5, Object o6, Object o7, Object o8, Object o9) {
		internalPrint(o0, o1, o2, o3, o4, o5, o6, o7, o8, o9);
		m_ps.println();		
	}
	
	public void printStackTrace() {
		for (StackInfo stack : StackInspector.getStack()) {
			m_ps.println(stack.toString());
		}
	}
	
	private void internalPrint(Object ... args) {
		for (Object o : args) {
			if (o != null && !(o instanceof Undefined)) {
				m_ps.print(toStringValue(o));
			}
		}
	}
	
	private String toStringValue(Object o) {
		if (o instanceof NativeJavaObject) {
			o = ((NativeJavaObject)o).unwrap();
		}
		else if (o instanceof ScriptableObject) {
			o = ((ScriptableObject)o).getDefaultValue(null);
		}
		return o.toString();
	}

}
