/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * OCL Interpreter                                                   *
 * Copyright (C) 2002 Nikolai Krambrock (nikk@gmx.de)                *
 * All rights reserved.                                              *
 *                                                                   *
 * This work was done as a diploma project at the Chair for Software *
 * Construction, University Of Technology Aachen, Germany            *
 * (http://www-lufgi3.informatik.rwth-aachen.de).                    *
 * It was done in co-operation with Software & Design and Managment  *
 * Troisdorf, Germany (http://www.sdm.de)                            *
 *                                                                   *
 * This work is free software; you can redistribute it and/or        *
 * modify it under the terms of the GNU Library General Public       *
 * License as published by the Free Software Foundation; either      *
 * version 2 of the License, or (at your option) any later version.  *
 *                                                                   *
 * This work is distributed in the hope that it will be useful,      *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of    *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU *
 * Library General Public License for more details.                  *
 *                                                                   *
 * You should have received a copy of the GNU Library General Public *
 * License along with this library; if not, write to the             *
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,      *
 * Boston, MA  02111-1307, USA.                                      *
 *                                                                   *
 * To submit a bug report, send a comment, or get the latest news on *
 * this project, please visit the project home page:                 *
 * http://dresden-ocl.sourceforge.net                                * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package tudresden.ocl.interp.exp.intern;

import tudresden.ocl.lib.OclBoolean;
import tudresden.ocl.lib.OclRoot;


/**
 * Represents a "if ... then ... else" construct in an ocl-constraint.
 * Evaluates the ifPart first and returns the evaluation of the thenPart or
 * the elsePart accordingly.
 */
public class ExpIf extends Exp {
  Exp ifPart;
  Exp thenPart;
  Exp elsePart;

  public ExpIf(Exp ifPart, Exp thenPart, Exp elsePart) {
    this.ifPart = ifPart;
    this.thenPart = thenPart;
    this.elsePart = elsePart;
  }

  public OclRoot evaluateInternal() {
    OclBoolean oclIfPart = (OclBoolean)ifPart.evaluate();
    if (oclIfPart.isUndefined()) {
      return oclIfPart;
    }
    if (oclIfPart.isTrue()) {
      return thenPart.evaluate();
    } else {
      return elsePart.evaluate();
    }
  }

  public Object[] children() {
    return new Object[] {ifPart, thenPart, elsePart};
  }
}