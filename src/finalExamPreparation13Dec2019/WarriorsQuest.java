package finalExamPreparation13Dec2019;

import java.util.Scanner;

public class WarriorsQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String command = scanner.nextLine();
        StringBuilder sb = new StringBuilder(input);

        while (!"For Azeroth".equals(command)) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];

            switch (action) {
                case "GladiatorStance":
                    sb.replace(0, sb.length(), sb.toString().toUpperCase());
                    System.out.println(sb.toString().toUpperCase());
                    break;
                case "DefensiveStance":
                    sb.replace(0, sb.length(), sb.toString().toLowerCase());
                    System.out.println(sb.toString().toLowerCase());
                    break;
                case "Dispel":
                    int index = Integer.parseInt(tokens[1]);
                    if (index < 0 || index >= sb.length()) {
                        System.out.println("Dispel too weak.");
                    } else {
                        char letter = tokens[2].charAt(0);
                        sb.setCharAt(index, letter);
                        System.out.println("Success!");
                    }
                    break;
                case "Target":
                    String secondCommand = tokens[1];
                    String substring = tokens[2];
                    int firstIndex = sb.indexOf(substring);
                    String saveChecker = sb.toString();
                    while (firstIndex != -1) {
                        switch (secondCommand) {
                            case "Change":
                                String strongSubstring = tokens[3];
                                sb.replace(firstIndex, firstIndex + substring.length(), strongSubstring);
                                break;
                            case "Remove":
                                sb.delete(firstIndex, firstIndex + substring.length());
                                break;
                        }
                        firstIndex = sb.indexOf(substring);
                    }
                    if (saveChecker.equals(sb.toString())) {
                        System.out.println("Command doesn't exist!");
                    } else {
                        System.out.println(sb);
                    }
                    break;

                default:
                    System.out.println("Command doesn't exist!");
            }
            command = scanner.nextLine();
        }
    }
}



// if ("Change".equals(secondCommand)) {
//                        String secondSubstring = tokens[3];
//                        System.out.println(sb.replace(firstIndex, substring.length() + firstIndex, secondSubstring));
//                    } else if ("Remove".equals(secondCommand)) {
//                        System.out.println(sb.delete(firstIndex, substring.length() + firstIndex));
//                    } else {
//                        System.out.println("Command doesn't exist!");
//                    }
//                    break;