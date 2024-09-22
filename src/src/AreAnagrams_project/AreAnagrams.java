package AreAnagrams_project;

import java.util.Arrays;

public class AreAnagrams {
    private String text1 = "";
    private String text2 = "";

    public AreAnagrams(String text1, String text2) {
        setText1(text1);
        setText2(text2);

        if(text1.isEmpty() || text2.isEmpty())
            System.out.println("Please the text's length must be greater than 0");
        AnagramCheck(text1, text2);
    }

    private void AnagramCheck(String text1, String text2) {
        String result = "";
        if ((text1.length() == text2.length())){
           char[] text11 = text1.toCharArray();
           char[] text22 = text2.toCharArray();

            Arrays.sort(text11);
            Arrays.sort(text22);

            if(Arrays.equals(text11, text22)){
                result = "Anagrams passed!";
                System.out.println(result);
            } else {
                result = "Anagrams not passed!";
                System.out.println(result);
            }
        }else {
            result = "Text's length does not match";
            System.out.println(result);
        }
    }

    private void setText1(String text1) {
        this.text1 = text1;
    }

    private void setText2(String text2) {
        this.text2 = text2;
    }
}
