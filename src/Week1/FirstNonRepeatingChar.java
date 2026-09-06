package Week1;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> counts = new LinkedHashMap<>();

        for (char c : text.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for (char c : text.toCharArray()) {
            if (counts.get(c) == 1) {
                return c;
            }
        }
        return '\0'; // Return null char if none exists
    }

    public static void testCharacterSearch(String text) {
        System.out.println("Input: \"" + text + "\"");
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'\n");
        } else {
            System.out.println("No Non-Repeating Character Found\n");
        }
    }

    public static void main(String[] args) {
        testCharacterSearch("swiss");
        testCharacterSearch("aabbcc");
    }
}