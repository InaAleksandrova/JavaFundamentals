package textProcessing_lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        while (!"end".equals(word)) {
            String reverse = reverseList(word);

            System.out.printf("%s = %s", word, reverse);
            System.out.println();

            word = scanner.nextLine();
        }
    }

    private static String reverse(String word) {
        String result = "";

        for (int i = word.length() - 1; i >= 0 ; i--) {
            result += word.charAt(i);
        }
        return result;
    }

    private static String reverseList(String word) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            result.add("" + word.charAt(i));
        }

        Collections.reverse(result);

        return String.join("", result);
    }
}
