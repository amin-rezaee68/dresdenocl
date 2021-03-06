/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.dresdenocl.language.ocl.resource.ocl.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class OclContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements org.dresdenocl.language.ocl.resource.ocl.IOclContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public OclContextDependentURIFragmentFactory(org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public org.dresdenocl.language.ocl.resource.ocl.IOclContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new org.dresdenocl.language.ocl.resource.ocl.mopp.OclContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
