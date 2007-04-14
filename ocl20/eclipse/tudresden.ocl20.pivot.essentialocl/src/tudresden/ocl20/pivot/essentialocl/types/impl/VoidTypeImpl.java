/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2007 Matthias Braeuer (braeuer.matthias@web.de).            *
 * All rights reserved.                                                      *
 *                                                                           *
 * This work was done as a project at the Chair for Software Technology,     *
 * Dresden University Of Technology, Germany (http://st.inf.tu-dresden.de).  *
 * It is understood that any modification not identified as such is not      *
 * covered by the preceding statement.                                       *
 *                                                                           *
 * This work is free software; you can redistribute it and/or modify it      *
 * under the terms of the GNU Library General Public License as published    *
 * by the Free Software Foundation; either version 2 of the License, or      *
 * (at your option) any later version.                                       *
 *                                                                           *
 * This work is distributed in the hope that it will be useful, but WITHOUT  *
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or     *
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Library General Public     *
 * License for more details.                                                 *
 *                                                                           *
 * You should have received a copy of the GNU Library General Public License *
 * along with this library; if not, you can view it online at                *
 * http://www.fsf.org/licensing/licenses/gpl.html.                           *
 *                                                                           *
 * To submit a bug report, send a comment, or get the latest news on this    *
 * project, please visit the website: http://dresden-ocl.sourceforge.net.    *
 * For more information on OCL and related projects visit the OCL Portal:    *
 * http://st.inf.tu-dresden.de/ocl                                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * $Id$
 */
package tudresden.ocl20.pivot.essentialocl.types.impl;

import org.eclipse.emf.ecore.EClass;

import tudresden.ocl20.pivot.essentialocl.types.VoidType;

import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.pivotmodel.impl.TypeImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Void Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class VoidTypeImpl extends TypeImpl implements VoidType {

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected VoidTypeImpl() {
    super();
  }

  /**
   * Void conforms to all other types (OCL 2.0 specification, Section 8.2.2):
   * 
   * <pre>
   * context VoidType
   * inv: Classifier.allInstances()-&gt;forAll (c | self.conformsTo (c))
   * </pre>
   * 
   * @see tudresden.ocl20.pivot.pivotmodel.impl.TypeImpl#conformsTo(tudresden.ocl20.pivot.pivotmodel.Type)
   */
  @Override
  @SuppressWarnings("unused")
  public boolean conformsTo(Type other) {
    return true;
  }

  /**
   * The common super type of <code>VoidType</code> and another {@link Type} is the other type. 
   * 
   * @return the given other type
   * 
   * @see tudresden.ocl20.pivot.pivotmodel.impl.TypeImpl#commonSuperType(tudresden.ocl20.pivot.pivotmodel.Type)
   */
  @Override
  public Type commonSuperType(Type other) {
    return other;
  }

  /**
   * Simply returns the name of the <code>VoidType</code> which will be <code>OclVoid</code>
   * because the OCL 2.0 Specification defines only this single instance. As a member of the OCL
   * Standard Library, <code>OclVoid</code> does not really have a namespace. It is implicitly
   * available in all namespaces.
   * 
   * @see tudresden.ocl20.pivot.pivotmodel.impl.NamedElementImpl#getQualifiedName()
   */
  @Override
  public String getQualifiedName() {
    return getName();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TypesPackageImpl.Literals.VOID_TYPE;
  }

} // VoidTypeImpl