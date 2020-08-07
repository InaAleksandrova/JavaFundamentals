package FinalExamPreparation13Dec2019;

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

            if ("Enroll".equals(command)) {
                heroes.putIfAbsent(name, new LinkedList<>());
                if (heroes.get(name).contains(name)) {
                    System.out.printf("%s is already enrolled.%n", name);
                }
            }
            List<String> spells = heroes.get(name);
            if ("Learn".equals(command)) {
                String spell1 = tokens[2];
                if (heroes.get(name).contains(name)) {
                    spells.add(spell1);
                } else if (!heroes.get(name).contains(name)) {
                    System.out.printf("%s doesn't exist.%n", name);
                } else if (heroes.get(name).contains(spell1)) {
                    System.out.printf("%s has already learnt %s.%n", name, spell1);
                }
            } else if ("Unlearn".equals(command)) {
                String spell2 = tokens[2];
                if (heroes.get(name).contains(name) && heroes.get(name).contains(spell2)) {
                    spells.remove(spell2);
                } else if (!heroes.get(name).contains(name)) {
                    System.out.printf("%s doesn't exist.%n", name);
                } else if (heroes.get(name).contains(spell2)) {
                    System.out.printf("%s doesn't know %s.%n", name, spell2);
                }
            }
            input = scanner.nextLine();
        }

    }

}

