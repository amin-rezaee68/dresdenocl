/*
Copyright (C) 2008-2009 by Claas Wilke (claaswilke@gmx.net)

This file is part of the OCL 2 Java Code Generator of Dresden OCL2 for Eclipse.

Dresden OCL2 for Eclipse is free software: you can redistribute it and/or modify 
it under the terms of the GNU Lesser General Public License as published by the 
Free Software Foundation, either version 3 of the License, or (at your option)
any later version.

Dresden OCL2 for Eclipse is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License 
for more details.

You should have received a copy of the GNU Lesser General Public License along 
with Dresden OCL2 for Eclipse. If not, see <http://www.gnu.org/licenses/>.
 */

package org.dresdenocl.tools.codegen.ui.impl.wizards;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;

import org.dresdenocl.tools.codegen.ui.impl.CodegenUIMessages;

/**
 * <p>
 * A {@link WizardPage} to select a destination folder for code generation.
 * </p>
 * 
 * @author Claas Wilke
 */
public class SelectDirectoryPage extends WizardPage {

	/**
	 * The directory is in the workspace of eclipse runtime.
	 */
	private IResource workspaceDirectory;

	/**
	 * The selection in the workspace, cached to automatically suggest the
	 * selected file.
	 */
	private IStructuredSelection selection;

	/** The text field that contains the output file name. */
	private Text directoryTextBox;

	/** The text field that contains the constraint sub directory for output. */
	private Text subDirectoryTextBox;

	private Group directoryConstraintGroup;

	/**
	 * <p>
	 * Create a new {@link SelectDirectoryPage} to select a directory for code
	 * generation output.
	 * </p>
	 * 
	 * @param selection
	 */
	public SelectDirectoryPage(IStructuredSelection selection) {

		super("SelectDirectoryPage");

		this.selection = selection;

		this.workspaceDirectory = null;

		setTitle(CodegenUIMessages.SelectDirectoryPage_Title);
		setDescription(CodegenUIMessages.SelectDirectoryPage_Description);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	public void createControl(Composite parent) {

		Composite panel;
		GridLayout layout;

		/* Create panel. */
		panel = new Composite(parent, SWT.NONE);

		/* Set panel attributes. */
		layout = new GridLayout(1, true);
		layout.verticalSpacing = 20;
		panel.setLayout(layout);
		panel.setFont(parent.getFont());

		/* Create UI elements. */
		this.createDirectoryFileGroup(panel);
		this.createConstraintDirectoryGroup(panel);

		/* Set the initial selection. */
		initializeFromSelection();
		updatePageComplete();

		/* Set the font. */
		Dialog.applyDialogFont(parent);

		/* Connect the wizard page with the wizard. */
		setControl(panel);
	}

	/**
	 * <p>
	 * Helper method to create a push button.
	 * </p>
	 */
	private Button createButton(Composite parent, String label) {

		Button result;

		result = new Button(parent, SWT.PUSH);
		result.setFont(parent.getFont());
		result.setText(label);

		return result;
	}

	/**
	 * <p>
	 * Creates the SWT group that allows selecting the a constraint sub directory.
	 * </p>
	 * 
	 * @param parent
	 *          The parent of this group.
	 */
	private void createConstraintDirectoryGroup(Composite parent) {

		Composite constraintDirectoryGroupComposite;

		Label locationLabel;
		GridLayout layout;

		/* Create a composite around the group. */
		constraintDirectoryGroupComposite = new Composite(parent, SWT.None);
		constraintDirectoryGroupComposite.setLayoutData(new GridData(SWT.FILL,
				SWT.TOP, true, false));

		/* We need another GridLayout to properly set additional margins. */
		layout = new GridLayout();
		constraintDirectoryGroupComposite.setLayout(layout);

		/* Create directory group and specify properties. */
		directoryConstraintGroup =
				new Group(constraintDirectoryGroupComposite, SWT.NONE);
		directoryConstraintGroup
				.setText(CodegenUIMessages.SelectDirectoryPage_SubDirectoryGroupText);
		directoryConstraintGroup.setLayoutData(new GridData(SWT.FILL, SWT.NONE,
				true, false));

		layout = new GridLayout(4, false);
		layout.horizontalSpacing = 10;
		directoryConstraintGroup.setLayout(layout);
		directoryConstraintGroup.setFont(parent.getFont());

		/* Create text label. */
		locationLabel = new Label(directoryConstraintGroup, SWT.None);
		locationLabel
				.setText(CodegenUIMessages.SelectDirectoryPage_SubDirectoryLabelText);

		/* Create text box. */
		this.subDirectoryTextBox =
				new Text(directoryConstraintGroup, SWT.SINGLE | SWT.BORDER);
		this.subDirectoryTextBox.setLayoutData(new GridData(SWT.FILL, SWT.NORMAL,
				true, false, 3, 1));
		this.subDirectoryTextBox
				.setText(CodegenUIMessages.SelectDirectoryPage_DefaultSubDirectory);

		/* Track modifications. */
		this.subDirectoryTextBox.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

				updatePageComplete();
			}

		});
	}

	/**
	 * <p>
	 * Creates the SWT group that allows selecting the output directory.
	 * </p>
	 * 
	 * @param parent
	 *          The parent of this group.
	 */
	private void createDirectoryFileGroup(Composite parent) {

		Composite directoryGroupComposite;
		Group directoryGroup;

		Label locationLabel, spacer;
		Button fBrowseWorkspaceButton, fBrowseFileButton;
		GridLayout layout;

		/* Create a composite around the group. */
		directoryGroupComposite = new Composite(parent, SWT.None);
		directoryGroupComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				false));

		/* We need another GridLayout to properly set additional margins. */
		layout = new GridLayout();
		directoryGroupComposite.setLayout(layout);

		/* Create directory group and specify properties. */
		directoryGroup = new Group(directoryGroupComposite, SWT.NONE);
		directoryGroup
				.setText(CodegenUIMessages.SelectDirectoryPage_DirectoryFileGroupText);
		directoryGroup.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));

		layout = new GridLayout(4, false);
		layout.horizontalSpacing = 10;
		directoryGroup.setLayout(layout);
		directoryGroup.setFont(parent.getFont());

		/* Create text label. */
		locationLabel = new Label(directoryGroup, SWT.None);
		locationLabel
				.setText(CodegenUIMessages.SelectDirectoryPage_LocationLabelText);

		/* Create text box. */
		directoryTextBox = new Text(directoryGroup, SWT.SINGLE | SWT.BORDER);
		directoryTextBox.setLayoutData(new GridData(SWT.FILL, SWT.NORMAL, true,
				false, 3, 1));

		/* Track modifications. */
		directoryTextBox.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

				updatePageComplete();
			}

		});

		/* The Spacing label. */
		spacer = new Label(directoryGroup, SWT.NONE);
		spacer.setLayoutData(new GridData(SWT.FILL, SWT.NORMAL, true, false, 2, 1));

		/* Create the buttons. */
		fBrowseWorkspaceButton =
				createButton(directoryGroup,
						CodegenUIMessages.SelectDirectoryPage_BrowseWorkspaceButtonText);
		fBrowseFileButton =
				createButton(directoryGroup,
						CodegenUIMessages.SelectDirectoryPage_BrowseFileSystemButtonText);

		/* Add listeners. */
		fBrowseWorkspaceButton.addSelectionListener(new BrowseWorkspaceListener());
		fBrowseFileButton.addSelectionListener(new BrowseFileListener());
	}

	/**
	 * <p>
	 * A helper method to decode a path.
	 * </p>
	 */
	private String decodePath(String path) {

		String returnPath;
		try {
			returnPath =
					VariablesPlugin.getDefault().getStringVariableManager()
							.performStringSubstitution(path);
		} catch (CoreException e) {
			returnPath = null;
		}

		return returnPath;
	}

	/**
	 * <p>
	 * A helper method to encode a workspace path.
	 * </p>
	 */
	private String encodePath(IResource resource) {

		String result;

		result =
				VariablesPlugin
						.getDefault()
						.getStringVariableManager()
						.generateVariableExpression("workspace_loc",
								resource.getFullPath().toString());

		return result;
	}

	/**
	 * <p>
	 * Initializes the file selection area from the selection in the workspace.
	 * </p>
	 */
	private void initializeFromSelection() {

		Object selectedObject;

		if (selection != null) {
			selectedObject = selection.getFirstElement();

			if (selectedObject instanceof IResource) {
				IResource selectedResource = (IResource) selectedObject;

				if (selectedResource.getType() == IResource.FILE) {
					directoryTextBox
							.setText(selectedResource.getRawLocation().toString());
				}
				// no else.
			}
			// no else.
		}
		// no else.
	}

	/**
	 * @return True if the entered sub directory is empty or denotes a valid sub
	 *         directory.
	 */
	private boolean isSubDirectoryValid() {

		boolean result;

		String subDirectory;

		subDirectory = this.getConstraintDirectory();

		if (subDirectory.length() > 0) {

			if (subDirectory.startsWith("/") || subDirectory.endsWith("/")) {
				result = false;
			}

			else {
				result = true;
			}
		}

		/* An empty value is a valid value. */
		else {
			result = true;
		}

		return result;
	}

	/**
	 * @return Returns a {@link File} representing the currently selected
	 *         directory.
	 */
	public File getDirectory() {

		File directory;
		String directoryName;

		/* By default the directory file is null. */
		directory = null;

		/* Determine the selected model file name. */
		directoryName = decodePath(getDirectoryFileName());

		if (directoryName != null) {
			directory = new Path(directoryName).toFile();
		}
		// no else.

		return directory;
	}

	/**
	 * <p>
	 * A helper method to return the name of the model file.
	 * </p>
	 */
	private String getDirectoryFileName() {

		return directoryTextBox.getText().trim();
	}

	/**
	 * @return Returns a {@link String} representing the sub directory for
	 *         Constraints.
	 */
	public String getConstraintDirectory() {

		String result;

		result = this.subDirectoryTextBox.getText();

		return result;
	}

	/**
	 * <p>
	 * Updates the <code>pageComplete</code> status of the wizard page.
	 * </p>
	 */
	private void updatePageComplete() {

		boolean complete;

		String directoryName;
		IPath directoryPath;
		File directoryFile;

		/* Reset messages. */
		setErrorMessage(null);
		setMessage(null);

		/* By default the page is not complete. */
		complete = false;

		/* Read the directory name. */
		directoryName = getDirectoryFileName();

		/* Check if the directory name is empty. */
		if (directoryName.length() == 0) {
			setErrorMessage(CodegenUIMessages.SelectDirectoryPage_MessagePleaseChooseDirectory);
		}

		else {

			/* Substitute variables in string. */
			directoryName = decodePath(directoryName);

			if (directoryName == null) {
				setErrorMessage(CodegenUIMessages.SelectDirectoryPage_ErrorMsgInvalidVariables);
			}

			else {
				/* Create a path for the directory file. */
				directoryPath = new Path(directoryName);

				/* Check if the directory exists. */
				directoryFile = directoryPath.toFile();

				if (directoryFile == null || !directoryFile.exists()) {
					setErrorMessage(CodegenUIMessages.SelectDirectoryPage_ErrorMsgDirectoryNotExisting);
				}

				/* Check if the directory file is a directory. */
				else if (directoryFile.isDirectory()) {

					/* Check if the sub directory has been set. */
					if (this.getConstraintDirectory().length() > 0) {

						/* Check if the sub directory is a valid name. */
						if (this.isSubDirectoryValid()) {
							complete = true;
						}
						else {
							setErrorMessage(CodegenUIMessages.SelectDirectoryPage_ErrorMsgInvalidSubDirectory);
						}
					}
					else {
						complete = true;
					}
				}

				else {
					setErrorMessage(CodegenUIMessages.SelectDirectoryPage_ErrorMsgIsNoDirectory);
				}

			}
		}

		setPageComplete(complete);
	}

	/**
	 * <p>
	 * A listener to react on a button click to browse the file system.
	 * </p>
	 */
	private class BrowseFileListener extends SelectionAdapter implements
			SelectionListener {

		/*
		 * (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
		 * .swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {

			DirectoryDialog dialog;
			String filePath;

			/* Open dialog. */
			dialog = new DirectoryDialog(getShell(), SWT.OPEN);
			filePath = dialog.open();

			/* If file was selected set path. */
			if (filePath != null) {
				workspaceDirectory = null;
				directoryTextBox.setText(filePath);
			}
		}
	}

	/**
	 * <p>
	 * A listener to react on a button click to browse the workspace.
	 * </p>
	 */
	private class BrowseWorkspaceListener extends SelectionAdapter implements
			SelectionListener {

		/*
		 * (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
		 * .swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {

			ElementTreeSelectionDialog dialog;

			int pressedButton;

			dialog =
					new ElementTreeSelectionDialog(getShell(),
							new WorkbenchLabelProvider(), new WorkbenchContentProvider());

			/* Configure dialog properties. */
			dialog
					.setTitle(CodegenUIMessages.SelectDirectoryPage_BrowseWorkspaceDialogTitle);
			dialog
					.setMessage(CodegenUIMessages.SelectDirectoryPage_BrowseWorkspaceDialogDescription);
			dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
			dialog.setComparator(new ResourceComparator(ResourceComparator.NAME));
			dialog.setAllowMultiple(false);

			/* Open the dialog. */
			do {
				pressedButton = dialog.open();
				workspaceDirectory = (IResource) dialog.getFirstResult();
			}

			while (pressedButton != IDialogConstants.CANCEL_ID
					&& workspaceDirectory.getType() != IResource.FOLDER);

			/* If OK was pressed set path. */
			if (pressedButton == IDialogConstants.OK_ID) {
				String fileLoc = encodePath(workspaceDirectory);
				directoryTextBox.setText(fileLoc);
			}
		}
	}

	public Group getDirectoryConstraintGroup() {

		return directoryConstraintGroup;
	}

	public void refreshDirectory() {

		if (this.workspaceDirectory != null) {
			try {
				Thread.sleep(1000);
				this.workspaceDirectory.refreshLocal(IResource.DEPTH_ONE, null);
			} catch (CoreException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
