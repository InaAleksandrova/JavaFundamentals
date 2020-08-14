package finalExamPreparation_03Aug2019_Group2;

import java.util.Scanner;

public class StringManipulatorGroup2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String command = scanner.nextLine();

        while (!"Done".equals(command)) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];

            switch (action) {
                case "Change":
                    String letter = tokens[1];
                    String replacement = tokens[2];
                    input = input.replaceAll(letter, replacement);
                    System.out.println(input);
                    break;
                case "Includes":
                    String includes = tokens[1];
                    if (input.contains(includes)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String end = tokens[1];
                    //String substring = input.substring(input.length() - end.length());
                    if (input.endsWith(end)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    input = input.replaceAll(input, input.toUpperCase());
                    System.out.println(input);
                    break;
                case "FindIndex":
                    String charAt = tokens[1];
                    int index = input.indexOf(charAt);
                    System.out.println(index);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    input = input.substring(startIndex, startIndex + length);
                    System.out.println(input);
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
