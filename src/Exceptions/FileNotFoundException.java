package Exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileNotFoundException {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Exceptions/file.txt"));
        String data = null;
        while((data=br.readLine())!=null){
            System.out.println(data);
        }
    }
}