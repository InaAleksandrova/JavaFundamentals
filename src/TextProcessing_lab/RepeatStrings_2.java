package TextProcessing_lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RepeatStrings_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        String result = Arrays.stream(words)
                .map(w -> repeatTimes(w, w.length()))
                .collect(Collectors.joining());

        System.out.println(result);
    }


    private static String repeatTimes(String word, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += word;
        }
        return result;
    }
}
