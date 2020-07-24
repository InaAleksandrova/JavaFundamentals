package AssotiativeArrays_exercises;

import java.lang.reflect.InaccessibleObjectException;
import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> students = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            Double studentGrade = Double.parseDouble(scanner.nextLine());

            students.putIfAbsent(studentName, new ArrayList<>());
            students.get(studentName).add(studentGrade);
        }

        students
                .entrySet()
                .stream()
                .filter(s -> s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.50)
                .sorted((s1, s2) -> {
                    double first = s1.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double second = s2.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    return Double.compare(second, first);
                })
                .forEach(s -> System.out.println(String.format("%s -> %.2f",
                        s.getKey(),
                        s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble()
                )));
    }
}
