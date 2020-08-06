package FinalExamPreparation_07Dec2019;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "!(?<command>[A-Z][a-z]{2,})!\\:\\[(?<message>[A-Za-z]{8,})\\]";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String command = matcher.group("command");
                String encryption = matcher.group("message");
                System.out.print(command + ": ");
                for (int j = 0; j < encryption.length(); j++) {
                    int letter = encryption.charAt(j);
                    System.out.print(letter + " ");
                }
            } else {
                System.out.printf("%nThe message is invalid%n");
            }
        }
    }
}
