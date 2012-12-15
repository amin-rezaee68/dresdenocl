package org.dresdenocl.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect Transaction_PostAspect4 {

    /**
     * <p>Pointcut for all calls on {@link org.dresdenocl.examples.royalsandloyals.Transaction#getProgram()}.</p>
     */
    protected pointcut getProgramCaller(org.dresdenocl.examples.royalsandloyals.Transaction aClass):
    	call(* org.dresdenocl.examples.royalsandloyals.Transaction.getProgram())
    	&& target(aClass);

    /**
     * <p>Checks a postcondition for the operation {@link Transaction#getProgram()} defined by the constraint
     * <code>context Transaction::getProgram() : org.dresdenocl.examples.royalsandloyals.LoyaltyProgram
     *       post: self.oclIsTypeOf(Transaction)</code></p>
     */
    org.dresdenocl.examples.royalsandloyals.LoyaltyProgram around(org.dresdenocl.examples.royalsandloyals.Transaction aClass): getProgramCaller(aClass) {
        /* Disable this constraint for subclasses of Transaction. */
        if (aClass.getClass().getCanonicalName().equals("org.dresdenocl.examples.royalsandloyals.Transaction")) {

        org.dresdenocl.examples.royalsandloyals.LoyaltyProgram result;
        result = proceed(aClass);

        if (!aClass.getClass().getCanonicalName().equals(org.dresdenocl.examples.royalsandloyals.Transaction.class.getCanonicalName())) {
        	// TODO Auto-generated code executed when constraint is violated.
        	String msg = "Error: Constraint 'undefined' (post: self.oclIsTypeOf(Transaction)) was violated for Object " + aClass.toString() + ".";
        	throw new RuntimeException(msg);
        }
        // no else.

        return result;
        }

        else {
            return proceed(aClass);
        }
    }
}