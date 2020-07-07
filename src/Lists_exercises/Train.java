package Lists_exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> train = readIntList(scanner);
        int capacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split(" ");
            if ("Add".equals(tokens[0])) {
                int people = Integer.parseInt(tokens[1]);
                train.add(people);
            } else {
                int peopleToAdd = Integer.parseInt(tokens[0]);
                for (int waggon = 0; waggon < train.size(); waggon++) {
                    int sum = train.get(waggon) + peopleToAdd;
                    if (train.get(waggon) + peopleToAdd <= capacity) {
                        train.set(waggon, sum);
                        break;
                    }
                }
            }

            input = scanner.nextLine();
        }
        printTrain(train);
    }


    private static List<Integer> readIntList(Scanner scanner) {
        List<Integer> train = new ArrayList<>();
        String[] input = scanner.nextLine().split(" ");
        for (String s : input) {
            train.add(Integer.parseInt(s));
        }
        return  train;
    }

    private static void printTrain(List<Integer> list) {
        for (Integer element : list) {
            System.out.print(element + " ");
        }
    }

}
