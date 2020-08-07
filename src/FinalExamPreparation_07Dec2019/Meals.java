package FinalExamPreparation_07Dec2019;

import java.util.*;

public class Meals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> meals = new LinkedHashMap<>();
        int count = 0;
        while (!"Stop".equals(input)) {
            String[] tokens = input.split("[-\\s+]");
            String command = tokens[0];
            String name = tokens[1];
            String meal = tokens[2];

            if (command.equals("Like")) {
                meals.putIfAbsent(name, new LinkedList<>());
                List<String> list = meals.get(name);
                if (!list.contains(meal)) {
                    list.add(meal);
                }

            } else {
                if (!meals.containsKey(name)) {
                    System.out.printf("%s is not at the party.%n", name);
                } else if (meals.containsKey(name)) {
                    if (meals.get(name).contains(meal)) {
                        System.out.printf("%s doesn't like the %s.%n", name, meal);
                        meals.get(name).remove(meal);
                        count++;
                    } else {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", name, meal);
                    }
                }
            }

            input = scanner.nextLine();
        }

        meals
                .entrySet()
                .stream()
                .sorted((c1, c2) -> {
                    if (c1.getValue().size() == c2.getValue().size()) {
                        return c1.getKey().compareTo(c2.getKey());
                    } else {
                        return Integer.compare(c2.getValue().size(), c1.getValue().size());
                    }
                })
                .forEach(entry ->
                        System.out.print(String.format("%s: %s%n", entry.getKey(), entry.getValue().toString().replaceAll("[\\[\\]]", "")))
                );

        System.out.println("Unliked meals: " + count);

    }
}