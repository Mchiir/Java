package Exceptions;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//video, continue with finally block
public class ExceptionsDemo {
    public static void main(String[] args) {
//        demo(null);
        try {
            var reader = new FileReader("file.txt");
            var value = reader.read();
            new SimpleDateFormat().parse("");
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
//            System.out.println("Could not read data.");
        }
    }

    public static void demo(String text) {
        System.out.println(text.toUpperCase());
    }
}
