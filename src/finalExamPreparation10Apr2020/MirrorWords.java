package finalExamPreparation10Apr2020;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "#(?<diez>[A-Za-z]{3,}##[A-Za-z]{3,})#|@(?<at>[A-Za-z]{3,}@@[A-Za-z]{3,})@";
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> validPairs = new ArrayList<>();
        Map<String, String> mirrorPairs = new LinkedHashMap<>();

        while (matcher.find()) {
            String item = matcher.group();
            validPairs.add(item);
        }

        if (validPairs.size() > 0) {
            System.out.println(validPairs.size() + " word pairs found!");
        } else {
            System.out.println("No word pairs found!");
        }

        for (int i = 0; i < validPairs.size(); i++) {
            String item = validPairs.get(i);
            if (item.contains("##")) {
                String[] current = item.split("##");
                String firstWord = current[0];
                String secondWord = current[1];
                String reversed = new StringBuilder(secondWord).reverse().toString();
                if (reversed.equals(firstWord)) {
                    mirrorPairs.put(firstWord.replaceAll("#", ""), secondWord.replaceAll("#", ""));
                }
            } else if (item.contains("@@")) {
                String[] current = item.split("@@");
                String firstWord = current[0];
                String secondWord = current[1];
                String reversed = new StringBuilder(secondWord).reverse().toString();
                if (reversed.equals(firstWord)) {
                    mirrorPairs.put(firstWord.replaceAll("@", ""), secondWord.replaceAll("@", ""));
                }
            }
        }
        if (mirrorPairs.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            int[] counter = {1};
            System.out.println("The mirror words are:");
            mirrorPairs
                    .entrySet()
                    .forEach(entry -> {
                            System.out.printf("%s <=> %s", entry.getKey(), entry.getValue());
                            if (counter[0] < (mirrorPairs).size()) {
                                System.out.print(", ");
                            }
                            counter[0]++;
                    });
        }
    }
}
