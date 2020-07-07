package Arrays_exercises;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] peoplePerWagon = new int[n];

        for (int i = 0; i < n; i++) {
            peoplePerWagon[i] = Integer.parseInt(scanner.nextLine());
        }

        int train = 0;
        for (int wagon : peoplePerWagon) {
            train += wagon;
            System.out.print(wagon + " ");
        }
        System.out.println();
        System.out.println(train);
    }
}
