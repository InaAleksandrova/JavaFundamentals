package TextProcessing_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            String stars = getStarsString(bannedWord.length());
            text = text.replace(bannedWord, stars);
        }
        System.out.println(text);
    }

    private static String getStarsString(int length) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            result.add("*");
        }
        return String.join("", result);
    }
}
