package Methods_Lab;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printTriangle(Integer.parseInt(scanner.nextLine()));
    }

    public static void printTriangle(int maxLineNumber) {
        for (int i = 1; i <= maxLineNumber; i++) {
            printRow(1, i);
            System.out.println();
        }

        for (int i = maxLineNumber - 1; i >= 1 ; i--) {
            printRow(1, i);
            System.out.println();
        }
    }


    public static void printRow(int from, int to) {
        for (int i = from; i <= to; i++) {
            System.out.print(i + " ");
        }
    }


}
