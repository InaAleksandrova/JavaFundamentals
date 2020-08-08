package finalExamPreparation_07Dec2019;

import java.util.Scanner;

public class NikuldensCharity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String commandLine = scanner.nextLine();

        while (!"Finish".equals(commandLine)){
            String[] tokens = commandLine.split("\\s+");
            String command = tokens[0];
            StringBuilder sb = new StringBuilder(input);
            switch (command) {
                case "Replace":
                    String currentChar = tokens[1];
                    String newChar = tokens[2];
                    while (input.contains(currentChar)) {
                        sb.insert(sb.indexOf(currentChar), newChar);
                        sb.deleteCharAt(sb.indexOf(currentChar));
                        input = sb.toString();
                    }
                    System.out.println(sb);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex < 0 || startIndex > input.length() && endIndex < 0 || endIndex > input.length()) {
                        System.out.println("Invalid indexes!");
                        break;
                    }
                    System.out.println(sb.delete(startIndex, endIndex + 1));
                    break;
                case "Make":
                    String cases = tokens[1];
                    if ("Upper".equals(cases)) {
                        input = sb.toString().toUpperCase();
                        System.out.println(sb.toString().toUpperCase());
                    } else {
                        input = sb.toString().toLowerCase();
                        System.out.println(sb.toString().toLowerCase());
                    }
                    break;
                case "Check":
                    String text = tokens[1];
                    if (input.contains(text)) {
                        System.out.println("Message contains " + text);
                    } else {
                        System.out.println("Message doesn't contain " + text);
                    }
                    break;
                case "Sum":
                    int start = Integer.parseInt(tokens[1]);
                    int end = Integer.parseInt(tokens[2]);
                    if (start < 0 || start > input.length() && end < 0 || end > input.length()) {
                        System.out.println("Invalid indexes!");
                        break;
                    }
                    String newString = sb.substring(start, end + 1);
                    int sum = 0;
                    for (int i = 0; i < newString.length(); i++) {
                        char current = newString.charAt(i);
                        sum = sum + current;
                    }
                    System.out.println(sum);
                    break;
            }

            commandLine = scanner.nextLine();
        }
        System.out.println();
    }

}
