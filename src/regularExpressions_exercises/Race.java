package regularExpressions_exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digitRegex = "\\d";
        String letterRegex = "[A-Za-z]";

        Pattern digitPattern = Pattern.compile(digitRegex);
        Pattern letterPattern = Pattern.compile(letterRegex);

        List<String> participants = new ArrayList<>();
        String[] input = scanner.nextLine().split(", ");
        for (String s : input) {
            participants.add(s);
        }
        //the same with stream API
        //List<String> participants2 = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> race = new LinkedHashMap<>();
        String inputLine = scanner.nextLine();
        while (!"end of race".equals(inputLine)) {
            StringBuilder sb = new StringBuilder();
            Matcher letterMatcher = letterPattern.matcher(inputLine);
            while (letterMatcher.find()) {
                sb.append(letterMatcher.group());
            }

            if (participants.contains(sb.toString())) {
                race.putIfAbsent(sb.toString(), 0);
                int km = race.get(sb.toString());

                Matcher digitMatcher = digitPattern.matcher(inputLine);
                while (digitMatcher.find()) {
                    km += Integer.parseInt(digitMatcher.group());
                }
                race.put(sb.toString(), km);
            }
            inputLine = scanner.nextLine();
        }
        List<String> output = new ArrayList<>();
        output.add("1st place: ");
        output.add("2nd place: ");
        output.add("3rd place: ");

        race
                .entrySet()
                .stream()
                .sorted((r1, r2) -> r2.getValue().compareTo(r1.getValue()))
                .limit(3)
                .forEach(r -> {
                    System.out.println(output.remove(0) + r.getKey());
                });
    }
}
