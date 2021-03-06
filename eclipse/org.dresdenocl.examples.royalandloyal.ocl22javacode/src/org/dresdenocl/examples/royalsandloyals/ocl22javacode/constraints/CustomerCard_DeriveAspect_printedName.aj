package org.dresdenocl.examples.royalsandloyals.ocl22javacode.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect CustomerCard_DeriveAspect_printedName {

    /**
     * <p>Pointcut for all requests on {@link org.dresdenocl.examples.royalsandloyals.ocl22javacode.CustomerCard#printedName}.</p>
     */
    protected pointcut printedNameGetter(org.dresdenocl.examples.royalsandloyals.ocl22javacode.CustomerCard aClass) :
    	get(* printedName) && target(aClass);

    /**
     * <p>Derives the attribute printedName defined by the constraint
     * <code>context CustomerCard
     *       derive: owner.title.concat(' ').concat(owner.name)</code></p>
     */
    before(org.dresdenocl.examples.royalsandloyals.ocl22javacode.CustomerCard aClass): printedNameGetter(aClass) {
        aClass.printedName = aClass.owner.title.concat(" ").concat(aClass.owner.name);
    }
}