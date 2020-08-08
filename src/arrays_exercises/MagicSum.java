package arrays_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int sum = Integer.parseInt(scanner.nextLine());
        int currSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                currSum = numbers[i] + numbers[j];
                if (currSum == sum) {
                    System.out.print(numbers[i] + " " + numbers[j]);
                    System.out.println();
                    break;
                }
            }
        }
    }
}
