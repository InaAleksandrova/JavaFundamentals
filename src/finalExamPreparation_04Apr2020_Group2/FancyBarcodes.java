package finalExamPreparation_04Apr2020_Group2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "@#+(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        String numbersRegex = "\\d+";
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            Pattern numberPattern = Pattern.compile(numbersRegex);
            Matcher numberMatcher = numberPattern.matcher(input);
            String defaultGroup = "00";
            String group = "";
            String numbers = "0";
            if (matcher.find()) {
                String barcode = matcher.group("barcode");
                if (numberMatcher.find()) {
                    numbers = numberMatcher.group();
                    for (int j = 0; j < barcode.length(); j++) {
                        char letter = barcode.charAt(j);
                        if (Character.isDigit(letter)) {
                            group += letter;
                        }
                    }
                    numbers = "";
                }
                if (barcode.contains(numbers)) {
                    System.out.println("Product group: " + group);
                } else {
                    System.out.println("Product group: " + defaultGroup);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
