public class SomeMethods {

    @Author({"Krzyś"})
    public void PrintDay(){
        System.out.println("Wednesday");
    }

    @Author({"Piotrek", "Marcin"})
    public void PrintHour(){
        System.out.println("12:00");
    }

    @Author({"Jacek", "Grześ", "Paweł"})
    public void PrintColor(){
        System.out.println("Red");
    }

    @Author({"Krzyś", "Jacek"})
    public void SaySmth(){
        System.out.println("Nothing");
    }
}
