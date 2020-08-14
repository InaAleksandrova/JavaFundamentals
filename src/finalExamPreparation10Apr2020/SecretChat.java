package finalExamPreparation10Apr2020;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder(message);

        while (!"Reveal".equals(input)) {
            String[] tokens = input.split(":\\|:");
            String command = tokens[0];

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    sb.insert(index, " ");
                    System.out.println(sb);
                    break;
                case "Reverse":
                    String substring = tokens[1];
                    int indexOfSubstring = sb.indexOf(substring);
                    if (indexOfSubstring >= 0) {
                        sb.delete(indexOfSubstring, indexOfSubstring + substring.length());
                        String reversed = new StringBuilder(substring).reverse().toString();
                        sb.append(reversed);
                        System.out.println(sb);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String toChange = tokens[1];
                    String replacement = tokens[2];
                    String replaced = sb.toString().replace(toChange, replacement);
                    sb = new StringBuilder(replaced);
                    System.out.println(sb);
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.println("You have a new message: " + sb);
    }
}
