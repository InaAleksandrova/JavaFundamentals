package AssotiativeArrays_lab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] parts = scanner.nextLine().split(" ");

        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();

        for (String part : parts) {
            String wordsInLowerCase = part.toLowerCase();
            if (counts.containsKey(wordsInLowerCase)) {
                counts.put(wordsInLowerCase, counts.get(wordsInLowerCase) + 1);
            } else {
                counts.put(wordsInLowerCase, 1);
            }
        }

        ArrayList<String> odds = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odds.add(entry.getKey());
            }
        }

        for (int i = 0; i < odds.size(); i++) {
            System.out.print(odds.get(i));
            if (i < odds.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
