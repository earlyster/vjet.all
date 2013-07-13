/*******************************************************************************
 * Copyright (c) 2008, 2012 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.mod.formatter;

import java.util.List;

public class FormatterUtils {

	public static boolean isSpace(char c) {
		return c == '\t' || c == ' ';
	}

	public static boolean isLineSeparator(char c) {
		return c == '\r' || c == '\n';
	}

	public static boolean isNewLine(IFormatterNode node) {
		if (node instanceof IFormatterTextNode) {
			final IFormatterTextNode textNode = (IFormatterTextNode) node;
			final IFormatterDocument document = node.getDocument();
			int start = textNode.getStartOffset();
			if (start < textNode.getEndOffset()) {
				if (document.charAt(start) == '\n') {
					++start;
				} else if (document.charAt(start) == '\r') {
					++start;
					if (start < textNode.getEndOffset()
							&& document.charAt(start) == '\n') {
						++start;
					}
				} else {
					return false;
				}
			}
			while (start < textNode.getEndOffset()) {
				if (!isSpace(document.charAt(start))) {
					return false;
				}
				++start;
			}
			return true;
		}
		return false;
	}

	/**
	 * @param node
	 * @return
	 */
	public static boolean isEmptyText(IFormatterNode node) {
		if (node instanceof IFormatterTextNode) {
			final String text = ((IFormatterTextNode) node).getText();
			for (int i = 0; i < text.length(); ++i) {
				char c = text.charAt(i);
				if (!Character.isWhitespace(c)) {
					return false;
				}
			}
		}
		return true;
	}

	public static IFormatterTextNode[] toTextNodeArray(List list) {
		if (list != null) {
			return (IFormatterTextNode[]) list
					.toArray(new IFormatterTextNode[list.size()]);
		} else {
			return null;
		}
	}

}
