package Functionals.Lambda;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        greet(new Printer(){             // instead of creating implementing Printer classes
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });
    }

    public static void greet(Printer printer){
        printer.print("Hello world");
    }
}
