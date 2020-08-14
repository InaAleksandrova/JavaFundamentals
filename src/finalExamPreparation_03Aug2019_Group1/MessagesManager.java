package finalExamPreparation_03Aug2019_Group1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MessagesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        Map<String, Integer> receivedMap = new LinkedHashMap<>();
        Map<String, Integer> sentMap = new LinkedHashMap<>();

        while (!"Statistics".equals(command)) {
            String[] tokens = command.split("=");
            String action = tokens[0];
            switch (action) {
                case "Add":
                    String username = tokens[1];
                    int sent = Integer.parseInt(tokens[2]);
                    int received = Integer.parseInt(tokens[3]);
                    receivedMap.putIfAbsent(username, received);
                    sentMap.putIfAbsent(username, sent);
                    break;
                case "Message":
                    String sender = tokens[1];
                    String receiver = tokens[2];
                    if (receivedMap.containsKey(receiver) && sentMap.containsKey(sender)) {
                        int newSent = sentMap.get(sender) + 1;
                        sentMap.put(sender, newSent);
                        int newReceiver = receivedMap.get(receiver) + 1;
                        receivedMap.put(receiver, newReceiver);
                        int sendersInbox = sentMap.get(sender) + receivedMap.get(sender);
                        int receiversInbox = receivedMap.get(receiver) + sentMap.get(receiver);
                        if (sentMap.get(sender) >= capacity || sendersInbox >= capacity) {
                            sentMap.remove(sender);
                            receivedMap.remove(sender);
                            System.out.println(sender + " reached the capacity!");
                        }
                        if (receivedMap.get(receiver) >= capacity || receiversInbox >= capacity) {
                            sentMap.remove(receiver);
                            receivedMap.remove(receiver);
                            System.out.println(receiver + " reached the capacity!");
                        }

                    }
                    break;
                case "Empty":
                    String user = tokens[1];
                    if (receivedMap.containsKey(user) || sentMap.containsKey(user)) {
                        receivedMap.remove(user);
                        sentMap.remove(user);
                    } else {
                        if (user.equals("All")) {
                            receivedMap.clear();
                            sentMap.clear();
                        }
                    }
                    break;

            }
            command = scanner.nextLine();
        }
        System.out.println("Users count: " + receivedMap.size());
        receivedMap
                .entrySet()
                .stream()
                .sorted((r1, r2) -> {
                    if (r1.getValue().equals(r2.getValue())) {
                        return r1.getKey().compareTo(r2.getKey());
                    } else {
                        return Integer.compare(r2.getValue(), r1.getValue());
                    }
                })
                .forEach(entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue() + sentMap.get(entry.getKey())));
    }
}
