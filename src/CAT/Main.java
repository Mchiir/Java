package CAT;

public class Main {
    public static void main(String[] args) {
        var tr1 = new Triangle(10, 20);
        var tr2 = new Triangle(10, 20);
        var tr3 = tr1;
        System.out.println(tr1 == tr3);// same memory pointer ?
        System.out.println(tr1.equals(tr3));// same object value(hashcode)?
    }
}

