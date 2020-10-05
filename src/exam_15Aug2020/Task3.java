package exam_15Aug2020;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> pieceMap = new LinkedHashMap<>();
        Map<String, String> keysMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String adding = scanner.nextLine();
            String[] tokens = adding.split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];
            pieceMap.put(piece, composer);
            keysMap.put(piece, key);
        }

        String input = scanner.nextLine();

        while (!"Stop".equals(input)) {
            String[] tokens = input.split("\\|");
            String action = tokens[0];
            String piece = tokens[1];
            switch (action) {
                case "Add":
                    String composer = tokens[2];
                    String key = tokens[3];
                    if (!pieceMap.containsKey(piece) || !keysMap.containsKey(piece)) {
                        pieceMap.put(piece, composer);
                        keysMap.put(piece, key);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    } else {
                        System.out.println(piece + " is already in the collection!");
                    }
                    break;
                case "Remove":
                    if (pieceMap.containsKey(piece)) {
                        pieceMap.remove(piece);
                        keysMap.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = tokens[2];
                    if (keysMap.containsKey(piece)) {
                        keysMap.put(piece, newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        pieceMap
                .entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    if (p1.getKey().equals(p2.getKey())) {
                        return p1.getValue().compareTo(p2.getValue());
                    } else {
                        return p1.getKey().compareTo(p2.getKey());
                    }
                })
                .forEach(entry -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                        entry.getKey(), entry.getValue(), keysMap.get(entry.getKey())));
    }
}

