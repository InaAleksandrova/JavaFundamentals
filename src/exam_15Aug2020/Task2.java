package exam_15Aug2020;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "([#|])(?<item>[A-Za-z\\s?]+)\\1(?<date>[0-9]{2}/[0-9]{2}/[0-9]{2})\\1(?<cal>[0-9]|[1-8][0-9]|9[0-9]|[1-8][0-9]{2}|9[0-8][0-9]|99[0-9]|[1-8][0-9]{3}|9[0-8][0-9]{2}|99[0-8][0-9]|999[0-9]|10000)\\1";
                //"([#|])(?<item>[A-Za-z\\s?]+)\\1(?<date>[0-9]{2}/[0-9]{2}/[0-9]{2})\\1(?<cal>[0-9]+)\\1";
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        Map<String, String> items = new LinkedHashMap<>();
        Map<String, Integer> dates = new LinkedHashMap<>();
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            while (matcher.find()) {
                String food = matcher.group("item");
                String date = matcher.group("date");
                int cal = Integer.parseInt(matcher.group("cal"));
                items.put(food, date);
                dates.put(food, cal);
                sum += cal;
            }
        }

        int days = sum / 2000;
        if (days > 0 ) {
            System.out.printf("You have food to last you for: %d days!%n", days);
        } else  {
            System.out.println("You have food to last you for: 0 days!");
        }

        items
                .forEach((key, value) -> System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n",
                        key, value, dates.get(key)));
    }
}
