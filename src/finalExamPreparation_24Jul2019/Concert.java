package finalExamPreparation_24Jul2019;

import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, List<String>> bandMembersMap = new LinkedHashMap<>();
        Map<String, Integer> bandTimeMap = new LinkedHashMap<>();

        while (!"start of concert".equals(command)) {
            int endIndex = command.lastIndexOf("; ");
            String first = command.substring(0, endIndex);
            String second = command.substring(endIndex + 1);
            String[] tokens = first.split(";\\s+");
            String[] tokens2 = second.split(",\\s+");
            String action = tokens[0];
            String bandName = tokens[1];

            switch (action) {
                case "Add":
                    for (String s : tokens2) {
                        String member = s.replaceAll("\\s+$", "").replaceAll("^\\s+", "");
                        if (!bandMembersMap.containsKey(bandName)) {
                            bandMembersMap.put(bandName, new LinkedList<>());
                            bandMembersMap.get(bandName).add(member);
                        } else {
                            if (!bandMembersMap.get(bandName).contains(member)) {
                                bandMembersMap.get(bandName).add(member);
                            }
                        }
                    }
                    if (!bandTimeMap.containsKey(bandName)) {
                        bandTimeMap.put(bandName, 0);
                    }
                    break;
                case "Play":
                    int time = Integer.parseInt(tokens2[0].replaceAll(" ", ""));
                    if (!bandTimeMap.containsKey(bandName)) {
                        bandTimeMap.put(bandName, time);
                    } else {
                        int newTime = bandTimeMap.get(bandName) + time;
                        bandTimeMap.put(bandName, newTime);
                    }
                    if (!bandMembersMap.containsKey(bandName)) {
                        bandMembersMap.put(bandName, new LinkedList<>());
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        int totalTime = bandTimeMap.values().stream().mapToInt(i -> i).sum();
        System.out.println("Total time: " + totalTime);
        bandTimeMap
                .entrySet()
                .stream()
                .sorted((b1, b2) -> {
                    if (b1.getValue().equals(b2.getValue())) {
                        return b1.getKey().compareTo(b2.getKey());
                    } else
                        return Integer.compare(b2.getValue(), b1.getValue());
                })
                .forEach(entry -> System.out.printf("%s -> %d%n",
                        entry.getKey(), entry.getValue()));

        String finalBand = scanner.nextLine();
        if (bandMembersMap.containsKey(finalBand)) {
            System.out.println(finalBand);
            bandMembersMap.get(finalBand).forEach(e -> System.out.println("=> " + e.replaceAll("[\\[\\]]", "")));
        }
    }
}

