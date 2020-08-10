package finalExamPreparation_04Apr2020_Group2;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rawPassword = scanner.nextLine();
        String command = scanner.nextLine();

        while (!"Done".equals(command)) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];
            switch (action) {
                case "TakeOdd":
                    String curr = "";
                    for (int i = 1; i < rawPassword.length(); i += 2) {
                        curr += rawPassword.charAt(i);
                    }
                    rawPassword = curr;
                    System.out.println(rawPassword);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    String firstPart = rawPassword.substring(0, index);
                    String secondPart = rawPassword.substring(index + length);
                    rawPassword = firstPart + secondPart;
                    System.out.println(rawPassword);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];
                    String current = "";
                    if (rawPassword.contains(String.valueOf(substring))) {
                        current = rawPassword.replaceAll(substring, substitute);
                        rawPassword = current;
                        System.out.println(rawPassword);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Your password is: " + rawPassword);
    }
}
