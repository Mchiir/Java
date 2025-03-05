package Collections.Queue;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> colors = new HashSet<String>();
        colors.add("red");
        colors.add("blue");
        colors.add("green");
        colors.add("green");
        System.out.println(colors);

        Collection<String> letters = new ArrayList<>();
        Collections.addAll(letters, "a", "b", "c", "c");
        Set<String> set = new HashSet<>(letters);
        System.out.println(set);

        List<String> list1 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        List<String> list2 = new ArrayList<>(Arrays.asList("b", "c", "d"));
        // Union
        list1.addAll(list2);
        Set<String> set1 = new HashSet<>(list1);
        System.out.println(set1);

//        // Intersection
//        list1.retainAll(list2);
//        System.out.println(list1);
//        // Difference
//        list1.removeAll(list2);
//        System.out.println(list1);
    }
}
