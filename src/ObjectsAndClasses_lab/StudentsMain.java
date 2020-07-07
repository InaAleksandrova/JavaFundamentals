package ObjectsAndClasses_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Students> students = new ArrayList<>();

        while (!line.equals("end")) {
            String[] parts = line.split(" ");
            String firstName = parts[0];
            String lastName = parts[1];
            int age = Integer.parseInt(parts[2]);
            String city = parts[3];

            Students student = new Students(firstName, lastName, age, city);
            students.add(student);

            line = scanner.nextLine();
        }
        String city = scanner.nextLine();

        for(Students student : students) {
            if(city.equals(student.getCity())) {
                System.out.printf("%s %s is %d years old%n",
                        student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}
