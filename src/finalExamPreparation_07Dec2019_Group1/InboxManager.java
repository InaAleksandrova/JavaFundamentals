package finalExamPreparation_07Dec2019_Group1;

import java.util.*;

public class InboxManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> statistics = new LinkedHashMap<>();

        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("->");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String username = tokens[1];
                    if (statistics.containsKey(username)) {
                        System.out.println(username + " is already registered");
                    }
                    statistics.putIfAbsent(username, new LinkedList<>());
                    break;
                case "Send":
                    String username1 = tokens[1];
                    String email = tokens[2];
                    statistics.get(username1).add(email);
                    break;
                case "Delete":
                    String username2 = tokens[1];
                    if (statistics.containsKey(username2)) {
                        statistics.remove(username2);
                    } else {
                        System.out.println(username2 + " not found!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Users count: " + statistics.size());
        statistics
                .entrySet()
                .stream()
                .sorted((u1, u2) -> {
                    if (u1.getValue().size() == u2.getValue().size()) {
                        return u1.getKey().compareTo(u2.getKey());
                    } else {
                        return Integer.compare(u2.getValue().size(), u1.getValue().size());
                    }
                })
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    entry.getValue().forEach(email -> System.out.printf(" - %s%n", email));
                });

    }
}
