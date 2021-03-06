/*
Copyright (C) 2010 by Claas Wilke (claaswilke@gmx.net)

This file is part of the PAIN Case Study of Dresden OCL2 for Eclipse.

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
package package1;

import java.util.Collection;

/**
 * <p>
 * A class of a simple test model.
 * </p>
 * 
 * @author Claas Wilke
 */
public class Class1 {

	/** Required to initialize undefined in constraints. */
	@SuppressWarnings("unused")
	private Boolean booleanNull = null;

	/** Required to initialize undefined in constraints. */
	@SuppressWarnings("unused")
	private Integer[] bagIntegerNull = null;

	/** Required to initialize undefined in constraints. */
	@SuppressWarnings("unused")
	private Integer integerNull = null;

	/** Required to test recursion of defined properties. */
	protected Class1 parent = null;

	/** Required to test closure operator. */
	protected Collection<Class1> children = null;
}
