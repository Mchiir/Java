package Exceptions;

public class Multiple {
    public static void main(String[] args) {
        int a = args.length;
        System.out.println("a= "+ a);
        int b = 42 / a;
        System.out.println(b);
        int[] c = {1};
        c[42] = 99;
        System.out.println(c);
    }
}