package finalExamPreparation_03Aug2019_Group1;

import java.util.Scanner;

public class StringManipulatorGroup1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String action = tokens[0];

            switch (action) {
                case "Translate":
                    String letter = tokens[1];
                    String replacement = tokens[2];
                    text = text.replaceAll(letter, replacement);
                    System.out.println(text);
                    break;
                case "Includes":
                    String includes = tokens[1];
                    if (text.contains(includes)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String start = tokens[1];
                    String substring = text.substring(0, start.length());
                    if (substring.equals(start)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    text = text.replaceAll(text, text.toLowerCase());
                    System.out.println(text);
                    break;
                case "FindIndex":
                    String charIndex = tokens[1];
                    int index = text.lastIndexOf(charIndex);
                    System.out.println(index);
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);
                    StringBuilder removed = new StringBuilder(text);
                    text = removed.delete(startIndex, startIndex + count).toString();
                    System.out.println(text);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
