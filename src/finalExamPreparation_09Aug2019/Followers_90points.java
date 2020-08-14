package finalExamPreparation_09Aug2019;

import java.util.*;
import java.util.stream.Collectors;

public class Followers_90points {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> likes = new LinkedHashMap<>();

        while (!"Log out".equals(input)) {
            String[] tokens = input.split(":\\s+");
            String command = tokens[0];
            String username = tokens[1];

            switch (command) {
                case "New follower":
                    likes.putIfAbsent(username, 0);
                    break;
                case "Like":
                    int count = Integer.parseInt(tokens[2]);
                    if (likes.containsKey(username)) {
                        likes.put(username, likes.get(username) + count);
                    } else {
                        likes.put(username, count);
                    }
                    break;
                case "Comment":
                    if (likes.containsKey(username)) {
                        likes.put(username, likes.get(username) + 1);
                    } else {
                        likes.put(username, 1);
                    }
                    break;
                case "Blocked":
                    if (likes.containsKey(username)) {
                        likes.remove(username);
                        likes.remove(username);
                    } else {
                        System.out.println(username + " doesn't exist.");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        int countFollower = likes.size();
        System.out.println(countFollower + " followers");

        likes
                .entrySet()
                .stream()
                .sorted((f1, f2) -> {
                    if (f1.getValue().equals(f2.getValue())) {
                        return f1.getKey().compareTo(f2.getKey());
                    } else {
                        return Integer.compare(f2. getValue(), f1.getValue());
                    }
                })
                .forEach(entry ->
                        System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));



    }
}
