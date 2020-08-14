package finalExamPreparation_03Aug2019_Group1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^([$%])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<num1>[0-9]+)\\]\\|\\[(?<num2>[0-9]+)\\]\\|\\[(?<num3>[0-9]+)\\]\\|$";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String tag = matcher.group("tag");
                char letter1 = (char) Integer.parseInt(matcher.group("num1"));
                char letter2 = (char) Integer.parseInt(matcher.group("num2"));
                char letter3 = (char) Integer.parseInt(matcher.group("num3"));
                System.out.printf("%s: %c%c%c%n", tag, letter1, letter2, letter3);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
