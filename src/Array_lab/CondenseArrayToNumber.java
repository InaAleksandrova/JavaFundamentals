package Array_lab;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split("\\s+");
        int[] newArray = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            newArray[i] = Integer.parseInt(numbers[i]);
        }

        while (newArray.length > 1) {
            int[] condensed = new int[newArray.length - 1];
            for (int i = 0; i < newArray.length - 1 ; i++) {
                condensed[i] = newArray[i] + newArray[i + 1];
            }
            newArray = condensed;
        }
        System.out.println(newArray[0]);
    }
}

