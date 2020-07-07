package Lists_exercises;

import com.sun.source.tree.BinaryTree;

import java.util.*;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = readIntList(scanner);
        int[] bombInfo = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int bomb = bombInfo[0];
        int power = bombInfo[1];

        while (numbers.contains(bomb)) {
            int index = numbers.indexOf(bomb);

            int leftBound = Math.max(index - power, 0);
            int rightBound = Math.min(index + power, numbers.size() - 1);
            for (int i = rightBound; i >= leftBound; i--) {
                numbers.remove(i);
            }
        }
        int sum = sumList(numbers);
        System.out.println(sum);

    }

    private static int sumList(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }

    private static boolean isValid(List<Integer> numbers, int index) {
        boolean result = index >= 0 && index < numbers.size();
        return result;
    }


    private static List<Integer> readIntList(Scanner scanner) {
        List<Integer> train = new ArrayList<>();
        String[] input = scanner.nextLine().split("\\s+");
        for (String s : input) {
            train.add(Integer.parseInt(s));
        }
        return train;
    }

    private static void printList(List<Integer> list) {
        for (Integer element : list) {
            System.out.print(element + " ");
        }
    }
}
;