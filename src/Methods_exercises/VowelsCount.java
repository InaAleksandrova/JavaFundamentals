package Methods_exercises;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        countVowels(text);
    }

    public static void countVowels(String word) {
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            char currentLetter = word.charAt(i);
            switch (currentLetter) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    counter++;
                    break;
            }
        }

        System.out.println(counter);
    }
}
