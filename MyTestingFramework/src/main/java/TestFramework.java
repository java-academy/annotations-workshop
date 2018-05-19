package main.java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

class TestFramework {
    static void runTestsFrom(Object objWithTests) {
        Method[] allMethods = objWithTests.getClass().getMethods();
        Method[] myTestMethods = getTestsWithAnnotation(allMethods, MyTest.class);
        Method[] myBeforeMethodMethods = getTestsWithAnnotation(allMethods, MyBeforeTest.class);

        for (Method m : myTestMethods){
            invokeMethods(objWithTests, myBeforeMethodMethods);
            invokeMethods(objWithTests, m);
        }
    }

    private static void invokeMethods(Object objWithTests, Method... methods) {
        for (Method method : methods) {
            if (method.getModifiers() == Modifier.PUBLIC) {
                try {
                    method.invoke(objWithTests);
                } catch (IllegalAccessException e) {
                    // TODO zalogować
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    // TODO zalogować
                    e.printStackTrace();
                }
            }
        }
    }

    private static Method[] getTestsWithAnnotation(Method[] allMethods, Class myTestClass) {
        List<Method> methodsToReturn = new ArrayList<>();
        for (Method m : allMethods){
            if (m.isAnnotationPresent(myTestClass))
                methodsToReturn.add(m);
        }
        return methodsToReturn.toArray(new Method[]{});
    }
}
