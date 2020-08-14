package finalExamPreparation_07Dec2019_Group1;

import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder(email);

        while (!"Complete".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Make":
                    String cases = tokens[1];
                    if ("Upper".equals(cases)) {
                        String toUpper = result.toString().replaceAll(result.toString(), result.toString().toUpperCase());
                        result = new StringBuilder(toUpper);
                        System.out.println(result);
                    } else if ("Lower".equals(cases)) {
                        String toLower = result.toString().replaceAll(result.toString(), result.toString().toLowerCase());
                        result = new StringBuilder(toLower);
                        System.out.println(result);
                    }
                    break;
                case "GetDomain":
                    int count = Integer.parseInt(tokens[1]);
                    String domain = result.substring(result.length() - count);
                    System.out.println(domain);
                    break;
                case "GetUsername":
                    if (!result.toString().contains("@")) {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", result);
                    } else {
                        int index = result.indexOf("@");
                        String username = result.substring(0, index);
                        System.out.println(username);
                    }
                    break;
                case "Replace":
                    String letter = tokens[1];
                    String newString = result.toString().replace(letter, "-");
                    result = new StringBuilder(newString);
                    System.out.println(result);
                    break;
                case "Encrypt":
                    for (int i = 0; i < result.length(); i++) {
                        int asciiValue = result.charAt(i);
                        System.out.print(asciiValue + " ");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
