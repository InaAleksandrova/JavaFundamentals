package assotiativeArrays_lab;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NumberCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");

        Map<Integer, Integer> occurrences = new TreeMap<>();
        for (String part : parts) {
            int currentNumber = Integer.parseInt(part);

            if (occurrences.containsKey(currentNumber)) {
                Integer currentCount = occurrences.get(currentNumber);
                occurrences.put(currentNumber, currentCount + 1);
            } else {
                occurrences.put(currentNumber, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: occurrences.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
