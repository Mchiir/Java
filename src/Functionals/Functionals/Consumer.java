package Functionals.Functionals;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Consumer {
   public static void main(String args[]){
       List<Integer> list = List.of(1, 2, 3);
       for(var n: list) // imperative prog
           System.out.println(n);

       list.forEach(System.out::println); // declarative prog
   }
}
