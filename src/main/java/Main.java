import java.lang.reflect.Method;
import java.util.HashMap;
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
        Map<Method, String[]> autorsWithMethods = processMapAuthorAndMethods(methods);
        printAuthorsWithCorrespondingMethods(autorsWithMethods);
    }

    private static void addMethodToCorrespondingAuthor(Map<Method, String[]> authorsWithMethods, Method method) {
        Author author = method.getAnnotation(Author.class);
        authorsWithMethods.put(method, author.value());
    }

    private static Map<Method, String[]> processMapAuthorAndMethods(Method[] methods) {
        Map <Method, String[]> authorsWithMethods = new HashMap<>();
        for (Method method : methods){
            if (method.isAnnotationPresent(Author.class) || method.isAnnotationPresent(Authors.class)) {
                addMethodToCorrespondingAuthor(authorsWithMethods, method);
            }
        }
        return authorsWithMethods;
    }

    private static void printAuthorsWithCorrespondingMethods(Map<Method, String[]> authorsWithMethods) {
        for (Method method : authorsWithMethods.keySet()){
            System.out.println("Method: " + method.getName());
            for (String authorName : authorsWithMethods.get(method)){
                System.out.println(authorName);
            }
            System.out.println();
        }
    }
}
