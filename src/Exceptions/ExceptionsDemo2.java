package Exceptions;

import java.io.FileReader;
import java.io.IOException;

public class ExceptionsDemo2 {
    public static void main(String[] args){
        FileReader reader = null;
        try {
            reader = new FileReader("file.txt");
            var value = reader.read();
            System.out.println(value);
        } catch (IOException e) {
            System.out.println("Could not read data.");
        } finally {
            if (reader != null) {
                try {
                    System.out.println("Hey, I've closed connection!");
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
