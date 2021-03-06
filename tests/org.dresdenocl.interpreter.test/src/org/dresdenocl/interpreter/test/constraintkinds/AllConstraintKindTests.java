/*
Copyright (C) 2011 by Claas Wilke (claaswilke@gmx.net)

This file is part of OCL2 Intepreter Test Suite of Dresden OCL.

Dresden OCL is free software: you can redistribute it and/or modify 
it under the terms of the GNU Lesser General Public License as published by the 
Free Software Foundation, either version 3 of the License, or (at your option)
any later version.

Dresden OCL is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License 
for more details.

You should have received a copy of the GNU Lesser General Public License along 
with Dresden OCL. If not, see <http://www.gnu.org/licenses/>.
 */
package org.dresdenocl.interpreter.test.constraintkinds;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * <p>
 * Provides a jUnit Test Suite containing tests testing the interpretation of
 * operations defined in the OCL Standard Library.
 * </p>
 * 
 * @author Claas Wilke
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ TestBody.class, TestDef.class, TestDerive.class,
		TestInit.class })
public class AllConstraintKindTests {
	/*
	 * This class remains completely empty, being used only as a holder for the
	 * above annotations.
	 */
}