package Lists_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();
        String secondInput = scanner.nextLine();

        List<Integer> first = inputToList(firstInput);
        List<Integer> second = inputToList(secondInput);

        int minLength = Math.min(first.size(), second.size());

        for (int i = 0; i < minLength; i++) {
            System.out.print(first.get(i) + " ");
            System.out.print(second.get(i) + " ");
        }

        printAfterIndex(first, minLength);
        printAfterIndex(second, minLength);

    }

    private static void printAfterIndex(List<Integer> list, int startIndex) {
        for (int i = startIndex; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }


    private static List<Integer> inputToList(String firstInput) {
        String[] parts = firstInput.split(" ");
        List<Integer> result = new ArrayList<>();

        for (String part : parts) {
            int current = Integer.parseInt(part);

            result.add(current);
        }

        return result;
    }
}
