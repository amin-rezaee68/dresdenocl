/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.dresdenocl.language.ocl.resource.ocl;

/**
 * An interface for factories to create instances of
 * org.dresdenocl.language.ocl.resource.ocl.IOclContextDependentURIFragment.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public interface IOclContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> {
	
	/**
	 * Create a new instance of the
	 * org.dresdenocl.language.ocl.resource.ocl.IOclContextDependentURIFragment
	 * interface.
	 * 
	 * @param identifier the identifier that references an Object
	 * @param container the object that contains the reference
	 * @param reference the reference itself
	 * @param positionInReference the position of the identifier (if the reference is
	 * multiple)
	 * @param proxy the proxy that will be resolved later to the actual EObject
	 * 
	 * @return the new instance of
	 * org.dresdenocl.language.ocl.resource.ocl.IOclContextDependentURIFragment
	 */
	public org.dresdenocl.language.ocl.resource.ocl.IOclContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy);
}
