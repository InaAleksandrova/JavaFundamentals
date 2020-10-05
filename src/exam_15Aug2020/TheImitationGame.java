package exam_15Aug2020;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        StringBuilder sb = new StringBuilder(message);
        String commands = scanner.nextLine();

        while (!"Decode".equals(commands)) {
            String[] tokens = commands.split("\\|");
            String action = tokens[0];
            switch (action) {
                case "Move":
                    int number = Integer.parseInt(tokens[1]);
                    String toMove = sb.substring(0, number);
                    sb.delete(0, number);
                    sb.append(toMove);
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    sb.insert(index, value);
                    break;
                case "ChangeAll":
                    String toChange = tokens[1];
                    String replacement = tokens[2];
                    String replaced = sb.toString().replace(toChange, replacement);
                    sb = new StringBuilder(replaced);
                    break;
            }
            commands = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + sb.toString());
    }
}
