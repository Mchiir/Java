package Char_frequency;

public class CharFrequency {
    private String text;
    private final int[] frequency = new int[256]; // Assuming ASCII characters
    private int index = -1;

    public CharFrequency(String text) {
        this.text = text;
    }

    public void counter() {
        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            frequency[c]++;
        }

        // Find the first non-repeated character
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("First non-repeated character: " + text.charAt(index));
        } else {
            System.out.println("No non-repeated characters found.");
        }
    }
}