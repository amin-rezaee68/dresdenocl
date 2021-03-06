package org.dresdenocl.examples.ocl22java.wizard;

import java.util.ArrayList;
import java.util.Collection;

import org.dresdenocl.examples.ui.wizard.AbstractExampleWizard;

/**
 * Wizard used to create the simple example project within the current Eclipse
 * workspace.
 * 
 * @author Claas Wilke
 */
public class SimpleExampleWizard extends AbstractExampleWizard {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dresdenocl.examples.ui.wizard.AbstractExampleWizard#
	 * getExamplePlugins()
	 */
	protected Collection<String[]> getExamplePlugins() {

		Collection<String[]> result = new ArrayList<String[]>(1);
		result.add(new String[] { "org.dresdenocl.examples.simple",
				"Dresden OCL - Simple UML/Java Example" });
		result.add(new String[] {
				"org.dresdenocl.examples.simple.ocl22javacode",
				"Dresden OCL - Simple Ocl2Java Example" });

		return result;
	}
}
