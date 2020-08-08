package methods_exercises;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        printTheSmallestNumber(a, b, c);
    }

    public static void printTheSmallestNumber(int a, int b, int c) {
        int smallest = a;
        if (b < a) {
            smallest = b;
        }
        if (c < b) {
            smallest = c;
        }
        System.out.println(smallest);
    }
}
