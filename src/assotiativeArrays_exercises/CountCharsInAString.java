package assotiativeArrays_exercises;

import java.util.*;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        Map<Character, Integer> chars = new LinkedHashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (chars.containsKey(letter)) {
                    Integer count = chars.get(letter);
                    chars.put(letter, count + 1);
                } else {
                    chars.put(letter, 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> letters : chars.entrySet()) {
            System.out.println(letters.getKey() + " -> " + letters.getValue());
        }
    }
}
