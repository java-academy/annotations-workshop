import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    /*

    Your program should have output like:

    Method: PrintDay
    - Krzyś

    Method: PrintHour
    - Piotrek
    - Marcin

    Method: PrintColor
    - Jacek
    - Grześ
    - Paweł


    ...

     You can modify all classes,
     but cannot change signature of annotation (there must be an array inside annotation)

    @Author({"Jacek", "Grześ", "Paweł"})

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
        Author [] authors = method.getAnnotationsByType(Author.class);
        for (Author author : authors) {
            if (authorsWithMethods.containsKey(author.value())) {
                authorsWithMethods.get(author.value()).add(method);
            } else {
                List<Method> list = new ArrayList<>();
                list.add(method);
                authorsWithMethods.put(author.value(), list);
            }
        }
    }

    private static Map<String, List<Method>> processMapAuthorAndMethods(Method[] methods) {
        Map <String, List<Method>> authorsWithMethods = new HashMap<>();
        for (Method method : methods){
            if (method.isAnnotationPresent(Author.class) || method.isAnnotationPresent(Authors.class)) {
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
