package Char_frequency;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeated {
    private final String text;
    public char c;

    public FirstNonRepeated(String text) {
        this.text = text;
        c = counter(text);
        System.out.println("The first non repeated character is '"+ c +"'");
    }

    public char counter(String str){
        Map<Character, Integer> map = new HashMap<>();
        for (var ch : str.toCharArray()) {
            var count = map.getOrDefault(ch, 0); //get char's count if it's already there || default to 0
            map.put(ch, count + 1); // increment char's count if already in hashmap key (char) -value (freq) pair
        }

        for (var ch : str.toCharArray()) {
            if (map.get(ch) == 1) return ch;
        }
        return 0;
    }
}