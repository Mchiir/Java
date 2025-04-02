package Collections.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

// with Collection interface we must be able to
// add T element
// remove T elements
// check contains T elements 

public class Main {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("A");
        Collections.addAll(collection, "B", "C", "D");

        // let's make our collection an array of strings
        Object[] objArray = collection.toArray();
        String[] strArray = collection.toArray(new String[0]);
        System.out.println(collection);
        System.out.println(collection.contains("A"));
        System.out.println(collection.remove("B"));
        System.out.println(collection.isEmpty());
        System.out.println(strArray);

        Collection<String> other = new ArrayList<>();
        other.addAll(collection);
        System.out.println(other == other);// -> false because it checks for mem address locations
        System.out.println(collection.equals(other));// -> true because it checks for content
        collection.clear();
    }
}