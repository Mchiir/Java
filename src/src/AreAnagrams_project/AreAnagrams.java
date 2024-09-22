package AreAnagrams_project;

public class AreAnagrams {
    private String text1 = "";
    private String text2 = "";

    public AreAnagrams(String text1, String text2) {
        setText1(text1);
        setText2(text2);

        AnagramCheck(text1, text2);
    }

    private void AnagramCheck(String text1, String text2) {
        String result = "";
        if ((text1.length() == text2.length())){
            for (int i = 0; i < text1.length(); i++){
                for (int j = 0; j < text2.length(); j++){
                    if (text1.charAt(i) == text2.charAt(j)){
                        result = "Anagrams passed";
                        break;
                    }else{
                        result = "Anagrams not passed";
                    }
                }
            }
            System.out.println(result);
        }else {
            result = "Text's length does not match";
            System.out.println(result);
        }
    }

    private void setText1(String text1) {
        if (text1.length() == 0)
            throw new IllegalArgumentException("Text1 is empty");
        this.text1 = text1;
    }

    private void setText2(String text2) {
        if (text2.length() == 0)
            throw new IllegalArgumentException("Text2 is empty");
        this.text2 = text2;
    }
}
