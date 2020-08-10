package finalExamPreparation_04Apr2020_Group1;

import java.util.Scanner;

// 85/100
public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder(input);
        String action = scanner.nextLine();

        while (!"Generate".equals(action)) {
            String[] tokens = action.split(">>>");
            String command = tokens[0];

            switch (command) {
                case "Contains":
                    String substring = tokens[1];
                    if (sb.toString().contains(substring)) {
                        System.out.printf("%s contains %s%n", input, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String cases = tokens[1];
                    int start = Integer.parseInt(tokens[2]);
                    int end = Integer.parseInt(tokens[3]);
                    if (cases.equals("Upper")) {
                        String subToUpper = sb.substring(start, end).toUpperCase();
                        sb.replace(start, end, subToUpper);
                        System.out.println(sb);
                    } else if (cases.equals("Lower")) {
                        String subToLower = sb.substring(start, end).toLowerCase();
                        sb.replace(start, end, subToLower);
                        System.out.println(sb);
                    }
                    break;
                case "Slice":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int ednIndex = Integer.parseInt(tokens[2]);
                    sb.delete(startIndex, ednIndex);
                    System.out.println(sb);
                    break;
            }
            action = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + sb);

    }
}
