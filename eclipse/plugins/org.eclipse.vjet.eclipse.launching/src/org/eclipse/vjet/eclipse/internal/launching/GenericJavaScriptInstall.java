package org.eclipse.vjet.eclipse.internal.launching;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.dltk.mod.launching.AbstractInterpreterInstall;
import org.eclipse.dltk.mod.launching.IInterpreterInstallType;
import org.eclipse.dltk.mod.launching.IInterpreterRunner;
import org.eclipse.vjet.eclipse.core.VjoNature;

public class GenericJavaScriptInstall extends AbstractInterpreterInstall {

	private static final String BUILTINS_JS = "builtins.js"; //$NON-NLS-1$

	public String getBuiltinModuleContent(String name) {
		InputStream stream = GenericJavaScriptInstall.class
				.getResourceAsStream(BUILTINS_JS);
		DataInputStream st = new DataInputStream(stream);
		StringBuffer buf = new StringBuffer();
		try {
			while (st.available() >= 0) {
				String line = st.readLine();
				if (line == null)
					break;
				buf.append(line);
				buf.append('\n');
			}

		} catch (IOException e) {
			// should not happen
		}
		return buf.toString();
	}

	public String[] getBuiltinModules() {
		return new String[] { "builtins.js" }; //$NON-NLS-1$
	}

	public long lastModified() {
		try {
			return GenericJavaScriptInstall.class.getResource(BUILTINS_JS)
					.openConnection().getLastModified();
		} catch (IOException e) {
			return 0;
		}
	}

	public GenericJavaScriptInstall(IInterpreterInstallType type, String id) {
		super(type, id);
	}

	public IInterpreterRunner getInterpreterRunner(String mode) {
		IInterpreterRunner runner = super.getInterpreterRunner(mode);
		if (runner != null) {
			return runner;
		}

		if (mode.equals(ILaunchManager.RUN_MODE)) {
			return new JavaScriptInterpreterRunner(this);
		}
		/*
		 * else if (mode.equals(ILaunchManager.DEBUG_MODE)) { return new
		 * JavaScriptInterpreterDebugger(this); }
		 */
		return null;
	}

	public String getNatureId() {
		return VjoNature.NATURE_ID;
	}
}
