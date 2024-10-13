package Char_frequency;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeated {
    private String text;
    private char c;

    public FirstRepeated(String text) {
        this.text = text;
        c = counter();
        System.out.println("The first repeated character is '" + c +"'");
    }

    private char counter() {
        Set<Character> set = new HashSet<Character>();
        for (char c : text.toCharArray()) {
            if (set.contains(c))return c;
            set.add(c);
        }
        return Character.MIN_VALUE;
    }
}
