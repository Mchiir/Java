package Roman_numeralToInteger;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Character, Integer> romanMap = new HashMap<>();
    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MXVII"));  // Output: 1017
        System.out.println(romanToInt("IX"));     // Output: 9
        System.out.println(romanToInt("XL"));     // Output: 40
        System.out.println(romanToInt("MCMXCIV"));// Output: 1994
    }

    public static int romanToInt(String roman) {
        if(roman.isEmpty()) return 0;

        int result = 0;
        int prevValue = 0;

        if(roman.length() == 1) return romanMap.get(roman.charAt(0));

        for(int i = roman.length()-1; i >= 0; i--) {
            int currentValue = romanMap.get(roman.charAt(i));

            // If previous numeral is larger, subtract current value
            if(currentValue < prevValue) {
                result -= currentValue;
            }else{
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }
}