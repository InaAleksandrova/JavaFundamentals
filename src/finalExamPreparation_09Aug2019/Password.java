package finalExamPreparation_09Aug2019;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "(\\S+)>(?<numbers>[0-9]{3})\\|(?<lowerLetters>[a-z]{3})\\|(?<upperLetters>[A-Z]{3})\\|(?<symbols>[^<>]{3})<\\1";
        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String password = scanner.nextLine();
            Matcher matcher = pattern.matcher(password);
            if (matcher.find()) {
                String group1 = matcher.group("numbers");
                String group2 = matcher.group("lowerLetters");
                String group3 = matcher.group("upperLetters");
                String group4 = matcher.group("symbols");
                System.out.println("Password: " + group1 + group2 + group3 + group4);
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
