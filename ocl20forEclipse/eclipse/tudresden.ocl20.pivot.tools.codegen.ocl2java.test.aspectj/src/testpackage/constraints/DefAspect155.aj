package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect155 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : testpackage.Class1 extends testpackage.constraints.ExtendedClass1;
    
    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#testStringToBoolean(String source)}.</p>
     */
    protected pointcut testStringToBooleanCaller(testpackage.Class1 aClass, String source):
    	call(* testpackage.Class1.testStringToBoolean(String))
    	&& target(aClass) && args(source);
    
    /**
     * <p>Defines the method testStringToBoolean(String source) defined by the constraint
     * <code>context Class1
     *       def: testStringToBoolean(source: String): Boolean =
    source.toBoolean()</code></p>
     */
    Boolean around(testpackage.Class1 aClass, String source): testStringToBooleanCaller(aClass, source) {
        return Boolean.parseBoolean(source);
    }
}