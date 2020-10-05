package exam_15Aug2020;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String command = scanner.nextLine();

        while (!"Decode".equals(command)) {
            String[] tokens = command.split("\\|");
            String actions = tokens[0];

            switch (actions) {
                case "Move":
                    int length = Integer.parseInt(tokens[1]);
                    if (length <= 0) {
                        break;
                    }
                    String toMove = input.substring(0, length);
                    String left = input.substring(length);
                    input = left + toMove;
//                    StringBuilder sb = new StringBuilder(input);
//                    sb.delete(0, length);
//                    sb.append(toMove);
//                    input = sb.toString();
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    if (index < 0 || index > input.length()) {
                        break;
                    }
                    String value = tokens[2];
                    String first = input.substring(0, index);
                    String second = input.substring(index);
                    input = first + value + second;
                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    input = input.replaceAll(substring, replacement);
                    while (input.contains(substring)) {
                        input = input.replaceAll(substring, replacement);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + input);
    }
}
