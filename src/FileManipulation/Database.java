package FileManipulation;

import java.io.File;

public class Database {
    public static void main(String[] args) {
        try {
            var fileCreator = new File("src/FileManipulation/Rwanda.txt");
            var Rwanda = fileCreator.createNewFile();
        } catch(Throwable e){
            System.out.println("Could not create file."+ e.getMessage());
        }
    }
}
