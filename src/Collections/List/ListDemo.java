package Collections.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add(0, "!");
        Collections.addAll(list, "c", "d", "e");
        list.set(0, "a+");
        list.remove(0);

        System.out.println(list.get(0));
        System.out.println(list.lastIndexOf("a")); // last occurence
        System.out.println(list.indexOf("a+")); // first occurence
        System.out.println(list.subList(0,2)); // FROM incl, TO excl
    }
}
