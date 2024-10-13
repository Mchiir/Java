package Char_frequency;

public class CharFrequency {
    private final String text;
    private final int[] frequency = new int[256];
    private int index = -1;

    public CharFrequency(String text) {
        this.text = text;
        System.out.println(text.length());
//        frequency = new int[text.length()];
    }

    public void counter() {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            System.out.println(frequency[c]);
            frequency[c]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                index = i;
                break;
            }
        }
        System.out.println(frequency.length);
        if (index != -1) {
            System.out.println("First non-repeated character: " + text.charAt(index));
        } else {
            System.out.println("No non-repeated characters found.");
        }
    }
}