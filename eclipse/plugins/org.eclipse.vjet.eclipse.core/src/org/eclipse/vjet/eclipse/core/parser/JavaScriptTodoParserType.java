/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.eclipse.core.parser;

import org.eclipse.dltk.mod.compiler.task.ITodoTaskPreferences;
import org.eclipse.dltk.mod.compiler.task.TodoTaskPreferences;
import org.eclipse.dltk.mod.core.IScriptProject;
import org.eclipse.dltk.mod.core.builder.AbstractTodoTaskBuildParticipantType;
import org.eclipse.dltk.mod.core.builder.IBuildParticipant;
import org.eclipse.vjet.eclipse.core.VjetPlugin;

public class JavaScriptTodoParserType extends
		AbstractTodoTaskBuildParticipantType {

	protected ITodoTaskPreferences getPreferences(IScriptProject project) {
		return new TodoTaskPreferences(VjetPlugin.getDefault()
				.getPluginPreferences());
	}

	protected IBuildParticipant getBuildParticipant(
			ITodoTaskPreferences preferences) {
		return new TodoTaskBuildParticipant(preferences) {
			protected int findCommentStart(char[] content, int begin, int end) {
				if (!isCheckRanges()) {
					begin = skipSpaces(content, begin, end);
					if (begin + 1 < end
							&& content[begin] == '/'
							&& (content[begin + 1] == '/' || content[begin + 1] == '*')) {
						return begin + 2;
					}
					return -1;
				}
				for (int i = begin; i < end; ++i) {
					if (content[i] == '/'
							&& (i + 1 < end && (content[i + 1] == '/' || content[i + 1] == '*'))
							&& isValid(i)) {
						return i + 2;
					}
				}
				return -1;
			}
		};
	}
}
