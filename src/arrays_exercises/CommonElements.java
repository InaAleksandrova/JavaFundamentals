package arrays_exercises;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split("\\s+");
        String[] secondLine = scanner.nextLine().split("\\s+");

        for (String elementOne : secondLine) {
            for (String elementTwo : firstLine) {
                if (elementOne.equals(elementTwo)) {
                    System.out.print(elementOne + " ");
                }
            }
        }
    }
}
