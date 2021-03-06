/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     eBay Inc - modification
 *******************************************************************************/
package org.eclipse.dltk.mod.internal.ui.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.dltk.mod.core.IMember;
import org.eclipse.dltk.mod.core.ISourceModule;
import org.eclipse.dltk.mod.core.ModelException;
import org.eclipse.dltk.mod.internal.corext.util.Messages;
import org.eclipse.dltk.mod.internal.ui.dnd.DLTKViewerDragAdapter;
import org.eclipse.dltk.mod.internal.ui.dnd.EditorInputTransferDragAdapter;
import org.eclipse.dltk.mod.internal.ui.dnd.ResourceTransferDragAdapter;
import org.eclipse.dltk.mod.internal.ui.scriptview.SelectionTransferDragAdapter;
import org.eclipse.dltk.mod.internal.ui.search.DLTKSearchResult.MatchFilterEvent;
import org.eclipse.dltk.mod.ui.DLTKPluginImages;
import org.eclipse.dltk.mod.ui.DLTKUIPlugin;
import org.eclipse.dltk.mod.ui.actions.SelectionDispatchAction;
import org.eclipse.dltk.mod.ui.search.IMatchPresentation;
import org.eclipse.dltk.mod.ui.util.ExceptionHandler;
import org.eclipse.dltk.mod.ui.viewsupport.ProblemTableViewer;
import org.eclipse.dltk.mod.ui.viewsupport.ProblemTreeViewer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.search.ui.IContextMenuConstants;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.AbstractTextSearchViewPage;
import org.eclipse.search.ui.text.Match;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.ui.part.ResourceTransfer;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;

import com.ibm.icu.text.Collator;

public class DLTKSearchResultPage extends AbstractTextSearchViewPage implements
		IAdaptable {

	public static class DecoratorIgnoringViewerSorter extends ViewerSorter {

		private final ILabelProvider fLabelProvider;
		private Comparator fNewCollator;

		public DecoratorIgnoringViewerSorter(ILabelProvider labelProvider) {
			super(null); // lazy initialization
			fLabelProvider = labelProvider;
			fNewCollator = null;
		}

		public int compare(Viewer viewer, Object e1, Object e2) {
			String name1 = fLabelProvider.getText(e1);
			String name2 = fLabelProvider.getText(e2);
			if (name1 == null)
				name1 = "";//$NON-NLS-1$
			if (name2 == null)
				name2 = "";//$NON-NLS-1$
			return getNewCollator().compare(name1, name2);
		}

		private final Comparator getNewCollator() {
			if (fNewCollator == null) {
				fNewCollator = Collator.getInstance();
			}
			return fNewCollator;
		}
	}

	private static final int DEFAULT_ELEMENT_LIMIT = 1000;
	private static final String FALSE = "FALSE"; //$NON-NLS-1$
	private static final String TRUE = "TRUE"; //$NON-NLS-1$
	private static final String KEY_GROUPING = "org.eclipse.dltk.mod.search.resultpage.grouping"; //$NON-NLS-1$
	private static final String KEY_SORTING = "org.eclipse.dltk.mod.search.resultpage.sorting"; //$NON-NLS-1$
	private static final String KEY_LIMIT_ENABLED = "org.eclipse.dltk.mod.search.resultpage.limit_enabled"; //$NON-NLS-1$
	private static final String KEY_LIMIT = "org.eclipse.dltk.mod.search.resultpage.limit"; //$NON-NLS-1$

	private static final String GROUP_GROUPING = "org.eclipse.dltk.mod.search.resultpage.grouping"; //$NON-NLS-1$
	private static final String GROUP_FILTERING = "org.eclipse.dltk.mod.search.resultpage.filtering"; //$NON-NLS-1$

	private NewSearchViewActionGroup fActionGroup;

	private SelectionDispatchAction fCopyQualifiedNameAction;

	private DLTKSearchContentProvider fContentProvider;
	private int fCurrentSortOrder;
	private SortAction fSortByNameAction;
	private SortAction fSortByParentName;
	private SortAction fSortByPathAction;

	private GroupAction fGroupTypeAction;
	private GroupAction fGroupFileAction;
	private GroupAction fGroupPackageAction;
	private GroupAction fGroupProjectAction;
	private int fCurrentGrouping;

	private FilterAction[] fFilterActions;
	private FiltersDialogAction fFilterDialogAction;

	private static final String[] SHOW_IN_TARGETS = new String[] {
			DLTKUIPlugin.ID_SCRIPTEXPLORER, IPageLayout.ID_RES_NAV };
	public static final IShowInTargetList SHOW_IN_TARGET_LIST = new IShowInTargetList() {
		public String[] getShowInTargetIds() {
			return SHOW_IN_TARGETS;
		}
	};

	private DLTKSearchEditorOpener fEditorOpener = new DLTKSearchEditorOpener();
	private boolean fLimitElements = false;
	private int fElementLimit;

	public DLTKSearchResultPage() {
		initSortActions();
		initGroupingActions();
		initFilterActions();
	}

	private void initFilterActions() {
		MatchFilter[] allFilters = MatchFilter.allFilters();
		fFilterActions = new FilterAction[allFilters.length];
		for (int i = 0; i < fFilterActions.length; i++) {
			fFilterActions[i] = new FilterAction(this, allFilters[i]);
			fFilterActions[i].setId("org.eclipse.dltk.mod.search.filters." + i); //$NON-NLS-1$
		}

		fFilterDialogAction = new FiltersDialogAction(this);
		fFilterDialogAction.setId("org.eclipse.dltk.mod.search.filters."
				+ allFilters.length);
		//$NON-NLS-1$
		DLTKPluginImages.setLocalImageDescriptors(fFilterDialogAction,
				"filter_ps.gif"); //$NON-NLS-1$
	}

	private void initSortActions() {
		fSortByNameAction = new SortAction(
				SearchMessages.DLTKSearchResultPage_sortByName, this,
				SortingLabelProvider.SHOW_ELEMENT_CONTAINER);
		fSortByPathAction = new SortAction(
				SearchMessages.DLTKSearchResultPage_sortByPath, this,
				SortingLabelProvider.SHOW_PATH);
		fSortByParentName = new SortAction(
				SearchMessages.DLTKSearchResultPage_sortByParentName, this,
				SortingLabelProvider.SHOW_CONTAINER_ELEMENT);
	}

	private void initGroupingActions() {
		fGroupProjectAction = new GroupAction(
				SearchMessages.DLTKSearchResultPage_groupby_project,
				SearchMessages.DLTKSearchResultPage_groupby_project_tooltip,
				this, LevelTreeContentProvider.LEVEL_PROJECT);
		DLTKPluginImages.setLocalImageDescriptors(fGroupProjectAction,
				"prj_mode.gif"); //$NON-NLS-1$
		fGroupPackageAction = new GroupAction(
				SearchMessages.DLTKSearchResultPage_groupby_package,
				SearchMessages.DLTKSearchResultPage_groupby_package_tooltip,
				this, LevelTreeContentProvider.LEVEL_PACKAGE);
		DLTKPluginImages.setLocalImageDescriptors(fGroupPackageAction,
				"package_mode.gif"); //$NON-NLS-1$
		fGroupFileAction = new GroupAction(
				SearchMessages.DLTKSearchResultPage_groupby_file,
				SearchMessages.DLTKSearchResultPage_groupby_file_tooltip, this,
				LevelTreeContentProvider.LEVEL_FILE);
		DLTKPluginImages.setLocalImageDescriptors(fGroupFileAction,
				"file_mode.gif"); //$NON-NLS-1$
		fGroupTypeAction = new GroupAction(
				SearchMessages.DLTKSearchResultPage_groupby_type,
				SearchMessages.DLTKSearchResultPage_groupby_type_tooltip, this,
				LevelTreeContentProvider.LEVEL_TYPE);
		DLTKPluginImages.setLocalImageDescriptors(fGroupTypeAction,
				"type_mode.gif"); //$NON-NLS-1$
	}

	public void setViewPart(ISearchResultViewPart part) {
		super.setViewPart(part);
		fActionGroup = new NewSearchViewActionGroup(part);
		// new
		// SearchActionGroup(this,DLTKLanguageManager.getLanguageToolkit(nature));
	}

	public void showMatch(Match match, int offset, int length, boolean activate)
			throws PartInitException {
		IEditorPart editor;
		try {
			editor = fEditorOpener.openMatch(match);
		} catch (ModelException e) {
			throw new PartInitException(e.getStatus());
		}

		if (editor != null && activate)
			editor.getEditorSite().getPage().activate(editor);
		Object element = match.getElement();
		if (editor instanceof ITextEditor) {
			ITextEditor textEditor = (ITextEditor) editor;
			textEditor.selectAndReveal(offset, length);
		} else if (editor != null) {
			if (element instanceof IFile) {
				IFile file = (IFile) element;
				showWithMarker(editor, file, offset, length);
			}
		} else {
			DLTKSearchResult result = (DLTKSearchResult) getInput();
			IMatchPresentation participant = result
					.getSearchParticpant(element);
			if (participant != null)
				participant.showMatch(match, offset, length, activate);
		}
	}

	private void showWithMarker(IEditorPart editor, IFile file, int offset,
			int length) throws PartInitException {
		try {
			IMarker marker = file.createMarker(NewSearchUI.SEARCH_MARKER);
			HashMap attributes = new HashMap(4);
			attributes.put(IMarker.CHAR_START, new Integer(offset));
			attributes.put(IMarker.CHAR_END, new Integer(offset + length));
			marker.setAttributes(attributes);
			IDE.gotoMarker(editor, marker);
			marker.delete();
		} catch (CoreException e) {
			throw new PartInitException(
					SearchMessages.DLTKSearchResultPage_error_marker, e);
		}
	}

	protected void fillContextMenu(IMenuManager mgr) {
		super.fillContextMenu(mgr);
		addSortActions(mgr);

		// eBay Mod. Start
		mgr.appendToGroup(IContextMenuConstants.GROUP_EDIT,
				getCopyQualifiedNameAction());
		// eBay Mod. End.

		fActionGroup.setContext(new ActionContext(getSite()
				.getSelectionProvider().getSelection()));
		fActionGroup.fillContextMenu(mgr);
	}

	private void addSortActions(IMenuManager mgr) {
		if (getLayout() != FLAG_LAYOUT_FLAT)
			return;
		MenuManager sortMenu = new MenuManager(
				SearchMessages.DLTKSearchResultPage_sortBylabel);
		sortMenu.add(fSortByNameAction);
		sortMenu.add(fSortByPathAction);
		sortMenu.add(fSortByParentName);

		fSortByNameAction.setChecked(fCurrentSortOrder == fSortByNameAction
				.getSortOrder());
		fSortByPathAction.setChecked(fCurrentSortOrder == fSortByPathAction
				.getSortOrder());
		fSortByParentName.setChecked(fCurrentSortOrder == fSortByParentName
				.getSortOrder());

		mgr.appendToGroup(IContextMenuConstants.GROUP_VIEWER_SETUP, sortMenu);
	}

	protected void fillToolbar(IToolBarManager tbm) {
		super.fillToolbar(tbm);
		if (getLayout() != FLAG_LAYOUT_FLAT)
			addGroupActions(tbm);
	}

	private void addGroupActions(IToolBarManager mgr) {
		mgr.appendToGroup(IContextMenuConstants.GROUP_VIEWER_SETUP,
				new Separator(GROUP_GROUPING));
		mgr.appendToGroup(GROUP_GROUPING, fGroupProjectAction);
		mgr.appendToGroup(GROUP_GROUPING, fGroupPackageAction);
		mgr.appendToGroup(GROUP_GROUPING, fGroupFileAction);
		mgr.appendToGroup(GROUP_GROUPING, fGroupTypeAction);

		updateGroupingActions();
	}

	private void updateGroupingActions() {
		fGroupProjectAction
				.setChecked(fCurrentGrouping == LevelTreeContentProvider.LEVEL_PROJECT);
		fGroupPackageAction
				.setChecked(fCurrentGrouping == LevelTreeContentProvider.LEVEL_PACKAGE);
		fGroupFileAction
				.setChecked(fCurrentGrouping == LevelTreeContentProvider.LEVEL_FILE);
		fGroupTypeAction
				.setChecked(fCurrentGrouping == LevelTreeContentProvider.LEVEL_TYPE);
	}

	public void dispose() {
		fActionGroup.dispose();
		super.dispose();
	}

	protected void elementsChanged(Object[] objects) {
		if (fContentProvider != null)
			fContentProvider.elementsChanged(objects);
	}

	protected void clear() {
		if (fContentProvider != null)
			fContentProvider.clear();
	}

	public void createControl(Composite parent) {
		super.createControl(parent);

		// Add by Oliver. 2009-11-02. add the F1 help for vjet search result
		// view.
		PlatformUI
				.getWorkbench()
				.getHelpSystem()
				.setHelp(parent,
						"org.eclipse.vjet.eclipse.ui.search_view_context");
	}

	private void addDragAdapters(StructuredViewer viewer) {
		Transfer[] transfers = new Transfer[] {
				LocalSelectionTransfer.getInstance(),
				ResourceTransfer.getInstance() };
		int ops = DND.DROP_COPY | DND.DROP_LINK;

		DLTKViewerDragAdapter dragAdapter = new DLTKViewerDragAdapter(viewer);
		dragAdapter.addDragSourceListener(new SelectionTransferDragAdapter(
				viewer));
		dragAdapter.addDragSourceListener(new EditorInputTransferDragAdapter(
				viewer));
		dragAdapter.addDragSourceListener(new ResourceTransferDragAdapter(
				viewer));
		viewer.addDragSupport(ops, transfers, dragAdapter);
	}

	protected void configureTableViewer(TableViewer viewer) {
		viewer.setUseHashlookup(true);
		SortingLabelProvider sortingLabelProvider = new SortingLabelProvider(
				this);
		viewer.setLabelProvider(new ColorDecoratingLabelProvider(
				sortingLabelProvider, PlatformUI.getWorkbench()
						.getDecoratorManager().getLabelDecorator()));
		fContentProvider = new DLTKSearchTableContentProvider(this);
		viewer.setContentProvider(fContentProvider);
		viewer.setSorter(new DecoratorIgnoringViewerSorter(sortingLabelProvider));
		setSortOrder(fCurrentSortOrder);
		addDragAdapters(viewer);
	}

	protected void configureTreeViewer(TreeViewer viewer) {
		PostfixLabelProvider postfixLabelProvider = new PostfixLabelProvider(
				this);
		viewer.setUseHashlookup(true);
		viewer.setSorter(new DecoratorIgnoringViewerSorter(postfixLabelProvider));
		viewer.setLabelProvider(new ColorDecoratingLabelProvider(
				postfixLabelProvider, PlatformUI.getWorkbench()
						.getDecoratorManager().getLabelDecorator()));
		fContentProvider = new LevelTreeContentProvider(this, fCurrentGrouping);
		viewer.setContentProvider(fContentProvider);
		addDragAdapters(viewer);
	}

	protected TreeViewer createTreeViewer(Composite parent) {
		return new ProblemTreeViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL) {
			public void add(Object parentElement, Object[] childElements) {
				if (limitElements() && parentElement.equals(getInput())) {
					Integer elementLimit = getElementLimit();
					Widget parentWidget = findItem(parentElement);
					if (parentWidget == null)
						return;
					Item[] children = getChildren(parentWidget);
					if (children.length >= elementLimit.intValue())
						return;
					if (children.length + childElements.length <= elementLimit
							.intValue()) {
						super.add(parentElement, childElements);
						return;
					}
					int toAdd = elementLimit.intValue() - children.length;
					Object[] limited = new Object[toAdd];
					System.arraycopy(childElements, 0, limited, 0,
							limited.length);
					super.add(parentElement, limited);
					return;
				} else {
					super.add(parentElement, childElements);
				}
			}

			protected Object[] getFilteredChildren(Object parentElement) {
				if (parentElement == null)
					return new Object[0];
				Object[] filtered = super.getFilteredChildren(parentElement);
				Integer elementLimit = getElementLimit();
				if (limitElements() && parentElement.equals(getInput())
						&& filtered.length > elementLimit.intValue()) {
					Object[] limited = new Object[elementLimit.intValue()];
					System.arraycopy(filtered, 0, limited, 0, limited.length);
					return limited;
				} else
					return filtered;
			}
		};
	}

	public Integer getElementLimit() {
		return new Integer(fElementLimit);
	}

	protected TableViewer createTableViewer(Composite parent) {
		return new ProblemTableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL) {

			public void add(Object[] elements) {
				if (limitElements()) {
					Integer elementLimit = getElementLimit();
					int currentCount = getTable().getItemCount();
					if (currentCount >= elementLimit.intValue())
						return;
					if (currentCount + elements.length <= elementLimit
							.intValue()) {
						super.add(elements);
						return;
					}
					int toAdd = elementLimit.intValue() - currentCount;
					Object[] limited = new Object[toAdd];
					System.arraycopy(elements, 0, limited, 0, limited.length);
					super.add(limited);
					return;
				} else {
					super.add(elements);
				}
			}

			protected Object[] getFilteredChildren(Object parentElement) {
				if (parentElement == null)
					return new Object[0];
				Object[] filtered = super.getFilteredChildren(parentElement);
				Integer elementLimit = getElementLimit();
				if (limitElements() && parentElement.equals(getInput())
						&& filtered.length > elementLimit.intValue()) {
					Object[] limited = new Object[elementLimit.intValue()];
					System.arraycopy(filtered, 0, limited, 0, limited.length);
					return limited;
				} else
					return filtered;
			}
		};
	}

	void setSortOrder(int order) {
		fCurrentSortOrder = order;
		StructuredViewer viewer = getViewer();
		viewer.getControl().setRedraw(false);
		DecoratingLabelProvider dlp = (DecoratingLabelProvider) viewer
				.getLabelProvider();
		((SortingLabelProvider) dlp.getLabelProvider()).setOrder(order);
		viewer.getControl().setRedraw(true);
		viewer.refresh();
		getSettings().put(KEY_SORTING, fCurrentSortOrder);
	}

	public void init(IPageSite site) {
		super.init(site);
		IMenuManager menuManager = site.getActionBars().getMenuManager();
		menuManager.insertBefore(IContextMenuConstants.GROUP_PROPERTIES,
				new Separator(GROUP_FILTERING));
		fActionGroup.fillActionBars(site.getActionBars());
		// TODO Disable menus
		// menuManager.appendToGroup(GROUP_FILTERING, fFilterDialogAction);
		menuManager.appendToGroup(IContextMenuConstants.GROUP_PROPERTIES,
				new Action(
						SearchMessages.DLTKSearchResultPage_preferences_label) {
					public void run() {
						String pageId = "org.eclipse.search.preferences.SearchPreferencePage"; //$NON-NLS-1$
						PreferencesUtil.createPreferenceDialogOn(
								DLTKUIPlugin.getActiveWorkbenchShell(), pageId,
								null, null).open();
					}
				});
	}

	/**
	 * Precondition here: the viewer must be showing a tree with a
	 * LevelContentProvider.
	 * 
	 * @param grouping
	 */
	void setGrouping(int grouping) {
		fCurrentGrouping = grouping;
		StructuredViewer viewer = getViewer();
		LevelTreeContentProvider cp = (LevelTreeContentProvider) viewer
				.getContentProvider();
		cp.setLevel(grouping);
		updateGroupingActions();
		getSettings().put(KEY_GROUPING, fCurrentGrouping);
		getViewPart().updateLabel();
	}

	protected StructuredViewer getViewer() {
		// override so that it's visible in the package.
		return super.getViewer();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.search.ui.text.AbstractTextSearchViewPage#restoreState(org
	 * .eclipse.ui.IMemento)
	 */
	public void restoreState(IMemento memento) {
		super.restoreState(memento);
		try {
			fCurrentSortOrder = getSettings().getInt(KEY_SORTING);
		} catch (NumberFormatException e) {
			fCurrentSortOrder = SortingLabelProvider.SHOW_ELEMENT_CONTAINER;
		}
		try {
			fCurrentGrouping = getSettings().getInt(KEY_GROUPING);
		} catch (NumberFormatException e) {
			fCurrentGrouping = LevelTreeContentProvider.LEVEL_PACKAGE;
		}
		fLimitElements = !FALSE.equals(getSettings().get(KEY_LIMIT_ENABLED));
		try {
			fElementLimit = getSettings().getInt(KEY_LIMIT);
		} catch (NumberFormatException e) {
			fElementLimit = DEFAULT_ELEMENT_LIMIT;
		}
		if (memento != null) {
			Integer value = memento.getInteger(KEY_GROUPING);
			if (value != null)
				fCurrentGrouping = value.intValue();
			value = memento.getInteger(KEY_SORTING);
			if (value != null)
				fCurrentSortOrder = value.intValue();
			fLimitElements = !FALSE
					.equals(memento.getString(KEY_LIMIT_ENABLED));
			value = memento.getInteger(KEY_LIMIT);
			if (value != null)
				fElementLimit = value.intValue();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.search.ui.text.AbstractTextSearchViewPage#saveState(org.eclipse
	 * .ui.IMemento)
	 */
	public void saveState(IMemento memento) {
		super.saveState(memento);
		memento.putInteger(KEY_GROUPING, fCurrentGrouping);
		memento.putInteger(KEY_SORTING, fCurrentSortOrder);
		if (fLimitElements)
			memento.putString(KEY_LIMIT_ENABLED, TRUE);
		else
			memento.putString(KEY_LIMIT_ENABLED, FALSE);
		memento.putInteger(KEY_LIMIT, getElementLimit().intValue());
	}

	void enableLimit(boolean enable) {
		fLimitElements = enable;
		if (fLimitElements)
			getSettings().put(KEY_LIMIT_ENABLED, TRUE);
		else
			getSettings().put(KEY_LIMIT_ENABLED, FALSE);
		limitChanged();
	}

	/**
	 * 
	 */
	private void limitChanged() {
		getViewer().refresh();
		getViewPart().updateLabel();
	}

	boolean limitElements() {
		return fLimitElements;
	}

	void removeMatchFilter(MatchFilter filter) {
		String id = filter.getID();
		MatchFilter[] matchFilters = getMatchFilters();
		ArrayList res = new ArrayList(matchFilters.length);
		for (int i = 0; i < matchFilters.length; i++) {
			if (!id.equals(matchFilters[i].getID())) {
				res.add(matchFilters[i]);
			}
		}
		MatchFilter[] newFilters = (MatchFilter[]) res
				.toArray(new MatchFilter[res.size()]);
		setFilters(newFilters);
	}

	void addMatchFilter(MatchFilter filter) {
		String id = filter.getID();
		MatchFilter[] matchFilters = getMatchFilters();
		ArrayList res = new ArrayList(matchFilters.length);
		for (int i = 0; i < matchFilters.length; i++) {
			if (!id.equals(matchFilters[i].getID())) {
				res.add(matchFilters[i]);
			}
		}
		res.add(filter);
		MatchFilter[] newFilters = (MatchFilter[]) res
				.toArray(new MatchFilter[res.size()]);
		setFilters(newFilters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.search.ui.text.AbstractTextSearchViewPage#
	 * handleSearchResultChanged(org.eclipse.search.ui.SearchResultEvent)
	 */
	protected synchronized void handleSearchResultChanged(SearchResultEvent e) {
		super.handleSearchResultChanged(e);
		if (e instanceof MatchFilterEvent) {
			filtersChanged(((MatchFilterEvent) e).getActivatedFilters());
		}
	}

	private void filtersChanged(MatchFilter[] newFilters) {
		StructuredViewer viewer = getViewer();
		DLTKSearchContentProvider cp = (DLTKSearchContentProvider) viewer
				.getContentProvider();
		cp.filtersChanged(getMatchFilters());

		updateFilterActions();

		getViewer().refresh();

		getViewPart().updateLabel();
	}

	private void updateFilterActions() {
		IMenuManager menu = getSite().getActionBars().getMenuManager();

		for (int i = 0; i < fFilterActions.length; i++) {
			fFilterActions[i].updateCheckState();
		}

		getSite().getActionBars().updateActionBars();
		menu.updateAll(true);
	}

	boolean hasMatchFilter(MatchFilter filter) {
		DLTKSearchResult input = (DLTKSearchResult) getInput();
		if (input != null) {
			return (input).hasMatchFilterActivated(filter);
		}
		return false;
	}

	MatchFilter[] getMatchFilters() {
		DLTKSearchResult input = (DLTKSearchResult) getInput();
		if (input != null) {
			return input.getActivatedMatchFilters();
		}
		return new MatchFilter[0];
	}

	public int getDisplayedMatchCount(Object element) {
		if (getMatchFilters().length == 0)
			return super.getDisplayedMatchCount(element);
		Match[] matches = super.getDisplayedMatches(element);
		int count = 0;
		for (int i = 0; i < matches.length; i++) {
			if (!matches[i].isFiltered())
				count++;
		}
		return count;
	}

	public Match[] getDisplayedMatches(Object element) {
		if (getMatchFilters().length == 0)
			return super.getDisplayedMatches(element);
		Match[] matches = super.getDisplayedMatches(element);
		int count = 0;
		for (int i = 0; i < matches.length; i++) {
			if (matches[i].isFiltered())
				matches[i] = null;
			else
				count++;
		}
		Match[] filteredMatches = new Match[count];

		int writeIndex = 0;
		for (int i = 0; i < matches.length; i++) {
			if (matches[i] != null)
				filteredMatches[writeIndex++] = matches[i];
		}

		return filteredMatches;
	}

	public void setInput(ISearchResult search, Object viewState) {
		super.setInput(search, viewState);
		DLTKSearchResult input = (DLTKSearchResult) search;
		updateFilterEnablement(input);
	}

	private void updateFilterEnablement(DLTKSearchResult result) {
		IActionBars bars = getSite().getActionBars();
		IMenuManager menu = bars.getMenuManager();
		for (int i = 0; i < fFilterActions.length; i++) {
			menu.remove(fFilterActions[i].getId());
		}

		for (int i = fFilterActions.length - 1; i >= 0; i--) {
			FilterAction filterAction = fFilterActions[i];
			if (shouldEnable(result, filterAction))
				menu.prependToGroup(GROUP_FILTERING, filterAction);
			filterAction.updateCheckState();
		}

		menu.updateAll(true);
		bars.updateActionBars();
	}

	private boolean shouldEnable(DLTKSearchResult result,
			FilterAction filterAction) {
		if (result == null) {
			return false;
		}
		DLTKSearchQuery query = (DLTKSearchQuery) result.getQuery();
		if (query == null)
			return false;
		return filterAction.getFilter().isApplicable(query);
	}

	private boolean isQueryRunning() {
		AbstractTextSearchResult result = getInput();
		if (result != null) {
			return NewSearchUI.isQueryRunning(result.getQuery());
		}
		return false;
	}

	public String getLabel() {
		String label = super.getLabel();
		if (getInput() != null) {
			int filteredOut = getInput().getMatchCount()
					- getFilteredMatchCount();
			if (filteredOut > 0 || getMatchFiltersCount() > 0) {
				if (isQueryRunning()) {
					String message = SearchMessages.DLTKSearchResultPage_filtered_message;
					return Messages.format(message, new Object[] { label });

				} else {
					String message = SearchMessages.DLTKSearchResultPage_filteredWithCount_message;
					return Messages.format(message, new Object[] { label,
							String.valueOf(filteredOut) });
				}
			}
		}
		return label;
	}

	private int getMatchFiltersCount() {
		MatchFilter[] filters = getMatchFilters();
		AbstractTextSearchResult result = getInput();
		if (result == null)
			return 0;
		int filterCount = 0;
		for (int i = 0; i < filters.length; i++) {
			if (filters[i].isApplicable((DLTKSearchQuery) result.getQuery()))
				filterCount++;
		}
		return filterCount;
	}

	private int getFilteredMatchCount() {
		StructuredViewer viewer = getViewer();
		if (viewer instanceof TreeViewer) {
			ITreeContentProvider tp = (ITreeContentProvider) viewer
					.getContentProvider();
			return getMatchCount(tp, getRootElements((TreeViewer) getViewer()));
		} else {
			return getMatchCount((TableViewer) viewer);
		}
	}

	private Object[] getRootElements(TreeViewer viewer) {
		Tree t = viewer.getTree();
		Item[] roots = t.getItems();
		Object[] elements = new Object[roots.length];
		for (int i = 0; i < elements.length; i++) {
			elements[i] = roots[i].getData();
		}
		return elements;
	}

	private Object[] getRootElements(TableViewer viewer) {
		Table t = viewer.getTable();
		Item[] roots = t.getItems();
		Object[] elements = new Object[roots.length];
		for (int i = 0; i < elements.length; i++) {
			elements[i] = roots[i].getData();
		}
		return elements;
	}

	private int getMatchCount(ITreeContentProvider cp, Object[] elements) {
		int count = 0;
		for (int j = 0; j < elements.length; j++) {
			count += getDisplayedMatchCount(elements[j]);
			Object[] children = cp.getChildren(elements[j]);
			count += getMatchCount(cp, children);
		}
		return count;
	}

	private int getMatchCount(TableViewer viewer) {
		Object[] elements = getRootElements(viewer);
		int count = 0;
		for (int i = 0; i < elements.length; i++) {
			count += getDisplayedMatchCount(elements[i]);
		}
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class adapter) {
		if (IShowInTargetList.class.equals(adapter)) {
			return SHOW_IN_TARGET_LIST;
		}
		return null;
	}

	protected void handleOpen(OpenEvent event) {
		Object firstElement = ((IStructuredSelection) event.getSelection())
				.getFirstElement();
		if (firstElement instanceof ISourceModule
				|| firstElement instanceof IMember) {
			if (getDisplayedMatchCount(firstElement) == 0) {
				try {
					fEditorOpener.openElement(firstElement);
				} catch (CoreException e) {
					ExceptionHandler
							.handle(e,
									getSite().getShell(),
									SearchMessages.DLTKSearchResultPage_open_editor_error_title,
									SearchMessages.DLTKSearchResultPage_open_editor_error_message);
				}
				return;
			}
		}
		super.handleOpen(event);
	}

	public void setFilters(MatchFilter[] enabledFilters) {
		DLTKSearchResult input = (DLTKSearchResult) getInput();
		if (input != null) {
			input.setActivatedFilters(enabledFilters);
		}
	}

	void setElementLimit(int elementLimit) {
		fElementLimit = elementLimit;
		getSettings().put(KEY_LIMIT, elementLimit);
		limitChanged();
	}

	// eBay Mod. Start. Add the copyQualifiedName Action.
	/**
	 * @return
	 */
	private SelectionDispatchAction getCopyQualifiedNameAction() {
		if (fCopyQualifiedNameAction == null) {
			fCopyQualifiedNameAction = new CopyQualifiedNameAction(getSite());
		}
		return fCopyQualifiedNameAction;
	}
	// eBay Mod. End.
}
