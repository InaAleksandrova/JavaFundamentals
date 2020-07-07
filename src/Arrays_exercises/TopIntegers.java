package Arrays_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] numbers = Arrays.stream(input).mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int i = 0; i < numbers.length - 1; i++) {
            int currentNum = numbers[i];
            boolean isTopInteger = true;
            for (int j = i + 1; j < numbers.length; j++) {
                if (currentNum <= numbers[j]) {
                    isTopInteger = false;
                    break;
                }
            }
            if (isTopInteger) {
                System.out.print(currentNum + " ");
            }
        }
        System.out.println(numbers[numbers.length - 1]);
    }
}
