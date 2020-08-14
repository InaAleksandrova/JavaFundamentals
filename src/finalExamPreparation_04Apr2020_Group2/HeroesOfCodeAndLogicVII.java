package finalExamPreparation_04Apr2020_Group2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> hitPointsMap = new LinkedHashMap<>();
        Map<String, Integer> manaPointsMap = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            String heroName = tokens[0];
            int hitPoints = Integer.parseInt(tokens[1]);
            int manaPoints = Integer.parseInt(tokens[2]);

            hitPointsMap.putIfAbsent(heroName, hitPoints);
            manaPointsMap.putIfAbsent(heroName, manaPoints);
        }

        String command = scanner.nextLine();

        while (!"End".equals(command)) {
            String[] tokens = command.split(" - ");
            String action = tokens[0];
            String heroName = tokens[1];

            switch (action) {
                case "CastSpell":
                    int neededManaPoints = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    if (manaPointsMap.get(heroName) < neededManaPoints) {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    } else {
                        int newManaPoints = manaPointsMap.get(heroName) - neededManaPoints;
                        manaPointsMap.put(heroName, newManaPoints);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, newManaPoints);
                    }
                    break;

                case "TakeDamage":
                    int damagePoints = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    int leftHp = hitPointsMap.get(heroName) - damagePoints;
                    if (leftHp <= 0) {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        hitPointsMap.remove(heroName);
                        manaPointsMap.remove(heroName);
                    } else {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damagePoints, attacker, leftHp);
                        hitPointsMap.put(heroName, leftHp);
                    }
                    break;

                case "Recharge":
                    int amountRecharge = Integer.parseInt(tokens[2]);
                    int difference = 0;
                    if (amountRecharge + manaPointsMap.get(heroName) > 200) {
                        difference = 200 - manaPointsMap.get(heroName);
                        manaPointsMap.put(heroName, 200);
                        System.out.printf("%s recharged for %d MP!%n", heroName, difference);
                    } else {
                        System.out.printf("%s recharged for %d MP!%n", heroName, amountRecharge);
                        difference = amountRecharge + manaPointsMap.get(heroName);
                        manaPointsMap.put(heroName, difference);
                    }
                    break;

                case "Heal":
                    int amount = Integer.parseInt(tokens[2]);
                    int diff = 0;
                    if (amount + hitPointsMap.get(heroName) > 100) {
                        diff = 100 - hitPointsMap.get(heroName);
                        hitPointsMap.put(heroName, 100);
                        System.out.printf("%s healed for %d HP!%n", heroName, diff);
                    } else {
                        System.out.printf("%s healed for %d HP!%n", heroName, amount);
                        diff = amount + hitPointsMap.get(heroName);
                        hitPointsMap.put(heroName, diff);
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        hitPointsMap
                .entrySet()
                .stream()
                .sorted((h1, h2) -> {
                    if (h1.getValue() == h2.getValue()) {
                        return h1.getKey().compareTo(h2.getKey());
                    } else {
                        return h2.getValue().compareTo(h1.getValue());
                    }
                })
                .forEach(entry -> System.out.printf("%s%n  HP: %d%n  MP: %d%n",
                        entry.getKey(), entry.getValue(), manaPointsMap.get(entry.getKey())));
    }
}






















