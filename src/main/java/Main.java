package main.java;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(5,4);
        System.out.println(ToStrings.toString(point));
        Rectangle rectangle = new Rectangle(point, 20, 20);
        System.out.println(ToStrings.toString(rectangle));
    }
}
