/*******************************************************************************
 * Copyright 2014 United States Government as represented by the
 * Administrator of the National Aeronautics and Space Administration.
 * All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package gov.nasa.ensemble.common.ui;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * The ScrollableMessageDialog is a modal dialog with the given text message in
 * a scrollable area. The text message is not manipulatable by the user.
 */
public class LogFileDialog extends MessageDialog {

	private static final int DEFAULT_TEXT_STYLE = SWT.MULTI | SWT.READ_ONLY | SWT.V_SCROLL	| SWT.H_SCROLL | SWT.WRAP;
	private static final int DEFAULT_FONT_HEIGHT;
	private static final Font FONT;

	/** initialize the default font size based on the operating system at runtime */
	static {
		String os = System.getProperty("osgi.os");
		if (os.startsWith("win")) {
			DEFAULT_FONT_HEIGHT = 8;
		} else if (os.startsWith("mac")) {
			DEFAULT_FONT_HEIGHT = 12;
		} else {
			DEFAULT_FONT_HEIGHT = 10;
		}
		FONT = new Font(null, new FontData("Courier", DEFAULT_FONT_HEIGHT,
					SWT.NORMAL));
	}

	private int textStyle;
	private int dialogHeight = 400;
	private int dialogWidth = 600;

	/**
	 * Construct a ScrollableMessageDialog
	 * 
	 * @param parent
	 * @param title
	 * @param message
	 */
	public LogFileDialog(Shell parent, String title, String message) {
		super(parent, title, null, message, MessageDialog.NONE,
				new String[] {IDialogConstants.OK_LABEL}, 0);
		
		textStyle = DEFAULT_TEXT_STYLE;
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}

	/**
	 * Create the contents of the dialog using a scrollable Text widget.
	 * 
	 * @param parent
	 *            the parent widget.
	 */
	@Override
	protected Control createContents(Composite parent) {
		Text text = new Text(parent, textStyle);
		text.setText(message);
		text.setFont(FONT);
		GridData textLayoutData = new GridData(SWT.CENTER, SWT.TOP, true,
				true);
		textLayoutData.grabExcessHorizontalSpace = true;
		textLayoutData.grabExcessVerticalSpace = true;
		text.setLayoutData(textLayoutData);
		text.setText(message);
		
		parent.setLayout(new GridLayout());
		parent.setLayoutData(new GridData(GridData.FILL_BOTH));
		parent.setSize(dialogWidth, dialogHeight);
		
		buttonBar = createButtonBar(parent);
		
		return parent;
	}
	
	/**
	 * give the option of changing the default text style
	 * 
	 * @param ts
	 */
	public void setTextStyle(int ts) {
		textStyle = ts;
	}
	
	
	public void setDefaultTextStyle() {
		textStyle = DEFAULT_TEXT_STYLE;
	}
	
	public void setDialogHeight(int h) {
		dialogHeight = h;
	}
	
	public void setDialogWidth(int w) {
		dialogWidth = w;
	}

}
