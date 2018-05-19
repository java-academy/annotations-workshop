package main.java;

public class SomeMethods {

    @Author(name = "Krzyś")
    public void PrintDay(){
        System.out.println("Wednesday");
    }

    @Author(name = "Piotrek")
    public void PrintHour(){
        System.out.println("12:00");
    }

    @Author(name = "Jacek")
    public void PrintColor(){
        System.out.println("Red");
    }

    @Author(name = "Krzyś")
    public void SaySmth(){
        System.out.println("Nothing");
    }
}
