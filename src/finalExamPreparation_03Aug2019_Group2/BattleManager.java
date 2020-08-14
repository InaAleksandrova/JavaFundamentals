package finalExamPreparation_03Aug2019_Group2;

import java.time.temporal.IsoFields;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BattleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Integer> healthMap = new LinkedHashMap<>();
        Map<String, Integer> energyMap = new LinkedHashMap<>();

        while (!"Results".equals(command)) {
            String[] tokens = command.split(":");
            String action = tokens[0];

            switch (action) {
                case "Add":
                    String personName = tokens[1];
                    int health = Integer.parseInt(tokens[2]);
                    int energy = Integer.parseInt(tokens[3]);
                    if (!healthMap.containsKey(personName)) {
                        healthMap.put(personName, health);
                        energyMap.put(personName, energy);
                    } else {
                        int increasedHealth = health + healthMap.get(personName);
                        healthMap.put(personName, increasedHealth);
                    }
                    break;
                case "Attack":
                    String attackerName = tokens[1];
                    String defenderName = tokens[2];
                    int damage = Integer.parseInt(tokens[3]);
                    if (healthMap.containsKey(attackerName) && healthMap.containsKey(defenderName)) {
                        int reducedHealth = healthMap.get(defenderName) - damage;
                        int reducedEnergy = energyMap.get(attackerName) - 1;
                        healthMap.put(defenderName, reducedHealth);
                        energyMap.put(attackerName, reducedEnergy);
                        if (reducedHealth <= 0) {
                            healthMap.remove(defenderName);
                            energyMap.remove(defenderName);
                            System.out.printf("%s was disqualified!%n", defenderName);
                        }
                        if (reducedEnergy <= 0) {
                            energyMap.remove(attackerName);
                            healthMap.remove(attackerName);
                            System.out.printf("%s was disqualified!%n", attackerName);
                        }
                    }

                    break;
                case "Delete":
                    String username = tokens[1];
                    if (healthMap.containsKey(username)) {
                        healthMap.remove(username);
                        energyMap.remove(username);
                    } else {
                        if("All".equals(username)) {
                            healthMap.clear();
                            energyMap.clear();
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("People count: " + healthMap.size());
        healthMap
                .entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    if (p1.getValue().equals(p2.getValue())) {
                        return p1.getKey().compareTo(p2.getKey());
                    } else {
                        return Integer.compare(p2.getValue(), p1.getValue());
                    }
                })
                .forEach(entry -> System.out.printf("%s - %d - %d%n",
                        entry.getKey(), entry.getValue(), energyMap.get(entry.getKey())));
    }
}
