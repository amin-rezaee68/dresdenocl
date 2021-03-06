/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.dresdenocl.language.ocl.resource.ocl.mopp;

public class OclProblem implements org.dresdenocl.language.ocl.resource.ocl.IOclProblem {
	
	private String message;
	private org.dresdenocl.language.ocl.resource.ocl.OclEProblemType type;
	private org.dresdenocl.language.ocl.resource.ocl.OclEProblemSeverity severity;
	private java.util.Collection<org.dresdenocl.language.ocl.resource.ocl.IOclQuickFix> quickFixes;
	
	public OclProblem(String message, org.dresdenocl.language.ocl.resource.ocl.OclEProblemType type, org.dresdenocl.language.ocl.resource.ocl.OclEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.dresdenocl.language.ocl.resource.ocl.IOclQuickFix>emptySet());
	}
	
	public OclProblem(String message, org.dresdenocl.language.ocl.resource.ocl.OclEProblemType type, org.dresdenocl.language.ocl.resource.ocl.OclEProblemSeverity severity, org.dresdenocl.language.ocl.resource.ocl.IOclQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public OclProblem(String message, org.dresdenocl.language.ocl.resource.ocl.OclEProblemType type, org.dresdenocl.language.ocl.resource.ocl.OclEProblemSeverity severity, java.util.Collection<org.dresdenocl.language.ocl.resource.ocl.IOclQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.dresdenocl.language.ocl.resource.ocl.IOclQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.dresdenocl.language.ocl.resource.ocl.OclEProblemType getType() {
		return type;
	}
	
	public org.dresdenocl.language.ocl.resource.ocl.OclEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.dresdenocl.language.ocl.resource.ocl.IOclQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
