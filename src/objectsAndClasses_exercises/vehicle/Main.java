package objectsAndClasses_exercises.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        List<Truck> trucks = new ArrayList<>();
        int carsHorsepower = 0;
        int trucksHorsepower = 0;
        String input = scanner.nextLine();
        while (!"End".equals(input)){
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsePower = Integer.parseInt(tokens[3]);
            if ("car".equals(type)) {
                Car car = new Car(model, color, horsePower);
                carsHorsepower += car.getHorsepower();
                cars.add(car);
            } else if ("truck".equals(type)) {
                Truck truck = new Truck(model, color, horsePower);
                trucksHorsepower += truck.getHorsepower();
                trucks.add(truck);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!"Close the Catalogue".equals(input)) {
            for (Car car : cars) {
                if (car.getModel().equals(input)) {
                    System.out.println(car);
                    break;
                }

            }
            for (Truck truck : trucks) {
                if (truck.getModel().equals(input)) {
                    System.out.println(truck);
                    break;
                }
            }
            input = scanner.nextLine();
        }

        double carsAverageHorsepower = 0;
        if (cars.size() != 0) {
           carsAverageHorsepower = carsHorsepower * 1.0 / cars.size();
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", carsAverageHorsepower);

        double trucksAverageHorsepower = 0;
        if (trucks.size() != 0) {
            trucksAverageHorsepower = trucksHorsepower * 1.0 / trucks.size();
        }
        System.out.printf("Trucks have average horsepower of: %.2f.%n", trucksAverageHorsepower);

    }
}
