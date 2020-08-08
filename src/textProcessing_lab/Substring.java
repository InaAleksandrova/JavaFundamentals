package textProcessing_lab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String token = scanner.nextLine();
        String input = scanner.nextLine();

//        int indexOfToken = input.indexOf(token);
//        while (indexOfToken >= 0) {
//            input = input.substring(0, indexOfToken) +
//                    input.substring(indexOfToken + token.length());
//
//            indexOfToken = input.indexOf(token);
//        }

        while (input.contains(token)) {
            input = input.replace(token, "");
        }

        System.out.println(input);
    }
}
