package finalExamPreparation_04Apr2020_Group1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Integer> populationMap = new LinkedHashMap<>();
        Map<String, Integer> goldMap = new LinkedHashMap<>();

        while (!command.equals("Sail")) {
            String[] tokens = command.split("\\|\\|");
            String city = tokens[0];
            int citizens = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            if (!populationMap.containsKey(city) && !goldMap.containsKey(city)) {
                populationMap.put(city, citizens);
                goldMap.put(city, gold);
            } else {
                int currentCitizens = populationMap.get(city) + citizens;
                populationMap.put(city, currentCitizens);
                int currentGold = goldMap.get(city) + gold;
                goldMap.put(city, currentGold);
            }

            command = scanner.nextLine();
        }

        String newCommand = scanner.nextLine();
        while (!"End".equals(newCommand)) {
            String[] tokens = newCommand.split("=>");
            String action = tokens[0];
            String town = tokens[1];

            if ("Plunder".equals(action)) {
                int people = Integer.parseInt(tokens[2]);
                int gold = Integer.parseInt(tokens[3]);

                int population = populationMap.get(town) - people;
                int newGold = goldMap.get(town) - gold;

                if (population <= 0 || newGold <= 0) {
                    populationMap.remove(town);
                    goldMap.remove(town);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                    System.out.println(town + " has been wiped off the map!");
                } else {
                    populationMap.put(town, population);
                    goldMap.put(town, newGold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                }

            } else if ("Prosper".equals(action)) {
                int gold = Integer.parseInt(tokens[2]);

                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    int newGold = goldMap.get(town) + gold;
                    goldMap.put(town, newGold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, newGold);
                }
            }

            newCommand = scanner.nextLine();
        }

        if (goldMap.isEmpty() && populationMap.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", goldMap.size());
        }

        goldMap
                .entrySet()
                .stream()
                .sorted((g1, g2) -> {
                    if (g1.getValue().equals(g2.getValue())) {
                        return g1.getKey().compareTo(g2.getKey());
                    } else {
                        return Integer.compare(g2.getValue(), g1.getValue());
                    }
                })
                .forEach( e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                        e.getKey(), populationMap.get(e.getKey()), e.getValue()));
    }
}
