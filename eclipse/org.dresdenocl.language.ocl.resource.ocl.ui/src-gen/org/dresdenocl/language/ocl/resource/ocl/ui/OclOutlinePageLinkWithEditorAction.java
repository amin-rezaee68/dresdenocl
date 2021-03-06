/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.dresdenocl.language.ocl.resource.ocl.ui;

public class OclOutlinePageLinkWithEditorAction extends org.dresdenocl.language.ocl.resource.ocl.ui.AbstractOclOutlinePageAction {
	
	public OclOutlinePageLinkWithEditorAction(org.dresdenocl.language.ocl.resource.ocl.ui.OclOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
