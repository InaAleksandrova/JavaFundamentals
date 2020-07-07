package Array_lab;

import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstArray = scanner.nextLine().split("\\s+");
        String[] secondArray = scanner.nextLine().split("\\s+");
        int sum = 0;

        for (int i = 0; i < firstArray.length; i++) {
            int firstNumbers = Integer.parseInt(firstArray[i]);
            int secondNumbers = Integer.parseInt(secondArray[i]);
            if (firstNumbers != secondNumbers) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                return;
            }
            sum += firstNumbers;
        }

        System.out.printf("Arrays are identical. Sum: %d", sum);
    }
}
