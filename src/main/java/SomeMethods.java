public class SomeMethods {

    @Author("Krzyś")
    public void PrintDay(){
        System.out.println("Wednesday");
    }

    @Author("Piotrek")
    @Author()
    public void PrintHour(){
        System.out.println("12:00");
    }

    @Author("Jacek")
    @Author("Grześ")
    @Author("Paweł")
    public void PrintColor(){
        System.out.println("Red");
    }

    @Author("Krzyś")
    @Author("Jacek")
    public void SaySmth(){
        System.out.println("Nothing");
    }
}
