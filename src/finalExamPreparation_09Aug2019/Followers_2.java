package finalExamPreparation_09Aug2019;

import java.util.*;

public class Followers_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> followers = new HashMap<>();

        String input = scanner.nextLine();
        while (!"Log out".equals(input)) {
            String[] tokens = input.split(":\\s+");
            String action = tokens[0];
            String username = tokens[1];

            switch (action) {
                case "New follower":
                    if (!followers.containsKey(username)) {
                        followers.put(username, new ArrayList<>());
                        followers.get(username).add(0, 0); // likes
                        followers.get(username).add(1, 0); // comments
                    }
                    break;
                case "Like":
                    int newLikes = Integer.parseInt(tokens[2]);
                    if (!followers.containsKey(username)) {
                        followers.put(username, new ArrayList<>());
                        followers.get(username).add(0, newLikes); // add the likes
                        followers.get(username).add(1, 0); // add 0 comments

                    } else {
                        int oldLikes = followers.get(username).get(0);  // get current likes from List
                        followers.get(username).set(0, newLikes + oldLikes); // re-write the likes
                    }
                    break;
                case "Comment":
                    int newComments = 1;
                    if (!followers.containsKey(username)) {
                        followers.put(username, new ArrayList<>());
                        followers.get(username).add(0, 0); // add 0 likes
                        followers.get(username).add(1, newComments); // add comments

                    } else {
                        int oldComments = followers.get(username).get(1);  // get current comments from List
                        followers.get(username).set(1, newComments + oldComments); // re-write the comments
                    }
                    break;
                case "Blocked":
                    if (!followers.containsKey(username)) {
                        System.out.printf("%s doesn't exist.%n", username);
                    } else {
                        followers.remove(username, followers.get(username));
                    }
                    break;
            }

            input = scanner.nextLine();
        }


        System.out.printf("%d followers%n", followers.size());
        followers.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    if (getLikes(e1.getValue()) == getLikes(e2.getValue())) {
                        return e1.getKey().compareTo(e2.getKey());
                    }

                    return Integer.compare(getLikes(e2.getValue()), getLikes(e1.getValue()));
                })
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), sumLikesAndComments(e.getValue())));

    }


    public static int sumLikesAndComments(List<Integer> list) {
        return list.get(0) + list.get(1);
    }

    public static int getLikes(List<Integer> list) {
        return list.get(0);
    }
}