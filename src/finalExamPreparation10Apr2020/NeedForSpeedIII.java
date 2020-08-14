package finalExamPreparation10Apr2020;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> mileageMap = new LinkedHashMap<>();
        Map<String, Integer> fuelMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);
            mileageMap.put(car, mileage);
            fuelMap.put(car, fuel);
        }

        String command = scanner.nextLine();
        while (!"Stop".equals(command)) {
            String[] tokens = command.split(" : ");
            String action = tokens[0];
            String car = tokens[1];

            switch (action) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);
                    if (fuel > fuelMap.get(car)) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        int currMileage = mileageMap.get(car) + distance;
                        mileageMap.put(car, currMileage);
                        int currFuel = fuelMap.get(car) - fuel;
                        fuelMap.put(car, currFuel);
                        if (mileageMap.get(car) >= 100_000) {
                            mileageMap.remove(car);
                            fuelMap.remove(car);
                            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                            System.out.printf("Time to sell the %s!%n", car);
                        } else {
                            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                        }
                    }
                    break;
                case "Refuel":
                    int fuelToRefuel = Integer.parseInt(tokens[2]);
                    if (fuelToRefuel + fuelMap.get(car) >= 75) {
                        int currFuel = 75 - fuelMap.get(car);
                        fuelMap.put(car, 75);
                        System.out.printf("%s refueled with %d liters%n", car, currFuel);
                    } else {
                        fuelMap.put(car, fuelToRefuel + fuelMap.get(car));
                        System.out.printf("%s refueled with %d liters%n", car, fuelToRefuel);
                    }
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);
                    if (mileageMap.get(car) - kilometers < 10_000) {
                        mileageMap.put(car, 10_000);
                    } else {
                        mileageMap.put(car, mileageMap.get(car) - kilometers);
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        mileageMap
                .entrySet()
                .stream()
                .sorted((c1, c2) -> {
                    if (c1.getValue() - c2.getValue() == 0) {
                        return c1.getKey().compareTo(c2.getKey());
                    } else {
                        return Integer.compare(c2.getValue(), c1.getValue());
                    }
                })
                .forEach(entry -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                        entry.getKey(), entry.getValue(), fuelMap.get(entry.getKey())));
    }
}
