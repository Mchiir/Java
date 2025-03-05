package Functionals.Lambda;

public class LambdasDemo {

    public LambdasDemo(String message) {

    }
    public String prefix = "-";
//    public static void print(String message) {};

    public static void main(String[] args) {
//        String prefix = "-";
//        greet((message) -> {
////            System.out.println(prefix + message);
//            System.out.println((new LambdasDemo()).prefix +message);
//        });
//        greet(message -> System.out.println(message));
//        greet(System.out::println);
//        Printer printer = message -> System.out.println(message);
//        greet(printer);

//        greet(message -> print(message));
//        greet(LambdasDemo::print);
        greet(message -> new LambdasDemo(""));
        greet(LambdasDemo::new);
    }

    public static void greet(Printer printer){
        printer.print("Hello World");
    }
}
