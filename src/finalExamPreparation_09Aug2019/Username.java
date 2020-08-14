package finalExamPreparation_09Aug2019;

import java.util.Scanner;

public class Username {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String command = scanner.nextLine();

        while (!"Sign up".equals(command)) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];

            switch (action) {
                case "Case":
                    String second = tokens[1];
                    if ("lower".equals(second)) {
                        input = input.replaceAll(input, input.toLowerCase());
                        System.out.println(input);
                    } else if ("upper".equals(second)) {
                        input = input.replaceAll(input, input.toUpperCase());
                        System.out.println(input);
                    }
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex < 0 || startIndex > input.length() || endIndex > input.length() || endIndex < startIndex) {
                        break;
                    } else {
                        StringBuilder substring = new StringBuilder(input.substring(startIndex, endIndex + 1));
                        System.out.println(substring.reverse());
                    }
                    break;
                case "Cut":
                    String part = tokens[1];
                    StringBuilder cutting = new StringBuilder(input);
                    if (input.contains(part)) {
                        int start = input.indexOf(part);
                        cutting.delete(start, start + part.length());
                        input = cutting.toString();
                        System.out.println(input);
                    } else {
                        System.out.printf("The word %s doesn't contain %s.%n", input, part);
                    }
                    break;
                case "Replace":
                    String replacement = tokens[1];
                    input = input.replaceAll(replacement, "*");
                    System.out.println(input);
                    break;
                case "Check":
                    String symbol = tokens[1];
                    if (input.contains(symbol)) {
                        System.out.println("Valid");
                    }
                    else {
                        System.out.printf("Your username must contain %s.%n", symbol);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
