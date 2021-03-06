/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.dresdenocl.language.ocl.resource.ocl.mopp;

public class OclFoldingInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getOperationContextDeclarationCS(),
			org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getAttributeContextDeclarationCS(),
			org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getClassifierContextDeclarationCS(),
			org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getInitValueCS(),
			org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getDeriveValueCS(),
			org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getInvariantExpCS(),
			org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getDefinitionExpCS(),
			org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getPreConditionDeclarationCS(),
			org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getPostConditionDeclarationCS(),
			org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getBodyDeclarationCS(),
		};
	}
	
}
