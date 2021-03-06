package org.dresdenocl.examples.royalsandloyals.ocl22javacode.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect LoyaltyProgram_PostAspect1 {

    /**
     * <p>Pointcut for all calls on {@link org.dresdenocl.examples.royalsandloyals.ocl22javacode.LoyaltyProgram#addService(org.dresdenocl.examples.royalsandloyals.ocl22javacode.ProgramPartner aPartner, org.dresdenocl.examples.royalsandloyals.ocl22javacode.ServiceLevel aLevel, org.dresdenocl.examples.royalsandloyals.ocl22javacode.Service aService)}.</p>
     */
    protected pointcut addServiceCaller(org.dresdenocl.examples.royalsandloyals.ocl22javacode.LoyaltyProgram aClass, org.dresdenocl.examples.royalsandloyals.ocl22javacode.ProgramPartner aPartner, org.dresdenocl.examples.royalsandloyals.ocl22javacode.ServiceLevel aLevel, org.dresdenocl.examples.royalsandloyals.ocl22javacode.Service aService):
    	call(* org.dresdenocl.examples.royalsandloyals.ocl22javacode.LoyaltyProgram.addService(org.dresdenocl.examples.royalsandloyals.ocl22javacode.ProgramPartner, org.dresdenocl.examples.royalsandloyals.ocl22javacode.ServiceLevel, org.dresdenocl.examples.royalsandloyals.ocl22javacode.Service))
    	&& target(aClass) && args(aPartner, aLevel, aService);

    /**
     * <p>Checks a postcondition for the operation {@link LoyaltyProgram#addService(, org.dresdenocl.examples.royalsandloyals.ocl22javacode.ProgramPartner aPartner, org.dresdenocl.examples.royalsandloyals.ocl22javacode.ServiceLevel aLevel, org.dresdenocl.examples.royalsandloyals.ocl22javacode.Service aService)} defined by the constraint
     * <code>context LoyaltyProgram::addService(aPartner: org.dresdenocl.examples.royalsandloyals.ocl22javacode.ProgramPartner, aLevel: org.dresdenocl.examples.royalsandloyals.ocl22javacode.ServiceLevel, aService: org.dresdenocl.examples.royalsandloyals.ocl22javacode.Service) : 
     *       post: levels.availableServices->includes(aService)</code></p>
     */
    void around(org.dresdenocl.examples.royalsandloyals.ocl22javacode.LoyaltyProgram aClass, org.dresdenocl.examples.royalsandloyals.ocl22javacode.ProgramPartner aPartner, org.dresdenocl.examples.royalsandloyals.ocl22javacode.ServiceLevel aLevel, org.dresdenocl.examples.royalsandloyals.ocl22javacode.Service aService): addServiceCaller(aClass, aPartner, aLevel, aService) {
        /* Disable this constraint for subclasses of LoyaltyProgram. */
        if (aClass.getClass().getCanonicalName().equals("org.dresdenocl.examples.royalsandloyals.ocl22javacode.LoyaltyProgram")) {

        proceed(aClass, aPartner, aLevel, aService);

        java.util.ArrayList<org.dresdenocl.examples.royalsandloyals.ocl22javacode.Service> result1;
        result1 = new java.util.ArrayList<org.dresdenocl.examples.royalsandloyals.ocl22javacode.Service>();

        /* Iterator Collect: Iterate through all elements and collect them. Elements which are collections are flattened. */
        for (org.dresdenocl.examples.royalsandloyals.ocl22javacode.ServiceLevel anElement1 : aClass.levels) {
            result1.addAll(anElement1.availableServices);
        }

        if (!org.dresdenocl.tools.codegen.ocl2java.types.util.OclCollections.includes(result1, aService)) {
        	// TODO Auto-generated code executed when constraint is violated.
        	String msg = "Error: Constraint 'undefined' (post: levels.availableServices->includes(aService)) was violated for Object " + aClass.toString() + ".";
        	throw new RuntimeException(msg);
        }
        // no else.
        }
        // no else.
    }
}