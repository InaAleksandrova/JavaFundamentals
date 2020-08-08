package finalExamPreparation13Dec2019;

import java.util.*;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> heroes = new LinkedHashMap<>();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String name = tokens[1];

            switch (command) {
                case "Enroll":
                    if (heroes.containsKey(name)) {
                        System.out.printf("%s is already enrolled.%n", name);
                    }
                    heroes.putIfAbsent(name, new LinkedList<>());
                    break;

                case "Learn":
                    String spell1 = tokens[2];
                    if (!heroes.containsKey(name)) {
                        System.out.printf("%s doesn't exist.%n", name);
                    } else {
                        if (!heroes.get(name).contains(spell1)) {
                            heroes.get(name).add(spell1);
                        } else {
                            System.out.printf("%s has already learnt %s.%n", name, spell1);

                        }
                    }
                    break;

                case "Unlearn":
                    String spell2 = tokens[2];
                    if (!heroes.containsKey(name)) {
                        System.out.printf("%s doesn't exist.%n", name);
                    } else {
                        if (heroes.get(name).contains(spell2)) {
                            heroes.get(name).remove(spell2);
                        } else {
                            System.out.printf("%s doesn't know %s.%n", name, spell2);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Heroes:%n");

        heroes
                .entrySet()
                .stream()
                .sorted((s1, s2) -> {
                    if (s1.getValue().size() == s2.getValue().size()) {
                        return s1.getKey().compareTo(s2.getKey());
                    } else {
                        return Integer.compare(s2.getValue().size(), s1.getValue().size());
                    }
                })
                .forEach(entry -> System.out.printf("== %s: %s%n", entry.getKey(),
                        entry.getValue().toString().replaceAll("[\\[\\]]", "")));
    }

}

