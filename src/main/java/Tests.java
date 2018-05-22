public class Tests
{
    @MyBeforeTest
    public void setUp(){
        System.out.println("I am invoked before any method with @MyTest annotation.");
    }

    @MyTest
    public void test1(){
        System.out.println("Test numer 1.");
    }

    @MyTest
    public void test2(){
        System.out.println("Test number 2.");
    }

    @MyTest
    public void test3(){
        System.out.println("Test number 3.");
    }
}
