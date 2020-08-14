package finalExamPreparation_03Aug2019_Group2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "([*@])(?<tag>[A-Z][a-z]{2,})(\\1): \\[(?<string1>[A-Za-z])\\]\\|\\[(?<string2>[A-Za-z])\\]\\|\\[(?<string3>[A-Za-z])\\]\\|$";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String tag = matcher.group("tag");
                int index1 = matcher.group("string1").charAt(0);
                int index2 = matcher.group("string2").charAt(0);
                int index3 = matcher.group("string3").charAt(0);
                System.out.printf("%s: %d %d %d%n", tag, index1, index2, index3);

            } else {
                System.out.println("Valid message not found!");
            }

        }
    }
}
