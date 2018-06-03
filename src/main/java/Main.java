package main.java;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    /* Fix that program to have an output like:

    Author: Jacek
    SaySmth
    PrintColor

    Author: Krzyś
    PrintDay
    SaySmth

    ...

    SomeMethods.java class HAS TO BE UNTOUCHED !
    */

    public static void main(String[] args) {
        SomeMethods someMethods = new SomeMethods();
        printMethodsCorrespondingToItsAuthors(someMethods);
    }

    private static void printMethodsCorrespondingToItsAuthors(Object someMethods) {
        Method[] methods = someMethods.getClass().getMethods();
        Map<String, List<Method>> autorsWithMethods = processMapAuthorAndMethods(methods);
        printAuthorsWithCorrespondingMethods(autorsWithMethods);
    }

    private static void addMethodToCorrespondingAuthor(Map<String, List<Method>> authorsWithMethods, Method method) {
        Author author = method.getAnnotation(Author.class);
        if (authorsWithMethods.containsKey(author.name())){
            authorsWithMethods.get(author.name()).add(method);
        }
        else{
            List <Method> list = new ArrayList<>();
            list.add(method);
            authorsWithMethods.put(author.name(), list);
        }
    }

    private static Map<String, List<Method>> processMapAuthorAndMethods(Method[] methods) {
        Map <String, List<Method>> authorsWithMethods = new HashMap<>();
        for (Method method : methods){
            if (method.isAnnotationPresent(Author.class)) {
                addMethodToCorrespondingAuthor(authorsWithMethods, method);
            }
        }
        return authorsWithMethods;
    }

    private static void printAuthorsWithCorrespondingMethods(Map<String, List<Method>> authorsWithMethods) {
        for (String author : authorsWithMethods.keySet()){
            System.out.println("Author: " + author);
            for (Method method : authorsWithMethods.get(author)){
                System.out.println(method.getName());
            }
            System.out.println();
        }
    }
}
