package Functionals.Lambda;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String m) {
        System.out.println(m);
    }
}
