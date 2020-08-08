package arrays_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int longest = 0;
        int digit = 0;
        int currLength = 1;
        for (int i = 0; i < numbers.length -1 ; i++) {
            int currNum = numbers[i];
            int nextNum = numbers[i + 1];
            if (currNum == nextNum) {
                currLength++;
                if (currLength > longest) {
                    longest = currLength;
                    digit = currNum;
                }
            } else {
                currLength = 1;
            }
        }
        for (int i = 0; i < longest; i++) {
            System.out.print(digit + " ");
        }
    }
}
