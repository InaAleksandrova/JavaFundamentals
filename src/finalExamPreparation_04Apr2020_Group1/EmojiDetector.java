package finalExamPreparation_04Apr2020_Group1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String emojiRegex = "::([A-Z][a-z]{2,})::|\\*\\*([A-Z][a-z]{2,})\\*\\*";
        String numbersRegex = "(\\d)";
        Pattern emojiPattern = Pattern.compile(emojiRegex);
        Pattern numbersPattern = Pattern.compile(numbersRegex);
        Matcher emojiMatcher = emojiPattern.matcher(input);
        Matcher numbersMatcher = numbersPattern.matcher(input);
        List<String> emojis = new ArrayList<>();
        List<String> coolEmojis = new ArrayList<>();
        int coolThreshold = 1;
        int emojiCounter = 0;
        int charSum = 0;

        while (numbersMatcher.find()) {
            int number = Integer.parseInt(numbersMatcher.group());
            coolThreshold *= number;
        }

        while (emojiMatcher.find()) {
            emojis.add(emojiMatcher.group());
        }

        for (int i = 0; i < emojis.size(); i++) {
            charSum = 0;
            String currentEmoji = emojis.get(i);  //.replaceAll("::|\\*\\*", "");
            emojiCounter ++;
            for (int j = 2; j < currentEmoji.length() - 2; j++) {
                char value = currentEmoji.charAt(j);
                charSum += value;
            }
            if (charSum >= coolThreshold) {
                coolEmojis.add(currentEmoji);
            }
        }

        System.out.println("Cool threshold: " + coolThreshold);
        System.out.println(emojiCounter + " emojis found in the text. The cool ones are:");
        coolEmojis.forEach(System.out::println);
    }
}

