package array_lab;

import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            String symbol = input[i];
        }

        for (int i = input.length - 1; i >= 0 ; i--) {
            System.out.print(input[i] + " ");
        }
    }
}
