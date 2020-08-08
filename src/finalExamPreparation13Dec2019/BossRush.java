package finalExamPreparation13Dec2019;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "\\|(?<name>[A-Z]{4,})\\|:#(?<position>[A-Za-z]+\\s[A-Za-z]+)#";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String bossName = matcher.group("name");
                String position = matcher.group("position");
                int nameStrength = bossName.length();
                int armourLength = position.length();
                System.out.printf("%s, The %s%n", bossName, position);
                System.out.println(">> Strength: " + nameStrength);
                System.out.println(">> Armour: "+ armourLength);
            } else  {
                System.out.println("Access denied!");
            }
        }

    }
}
