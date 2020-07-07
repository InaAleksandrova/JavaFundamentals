package Methods_Lab;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());

        printGrade(grade);
    }

    private static void printGrade(double grade) {
        String gradeInWords = "Fail";

        if (grade >= 3 && grade < 3.5) {
            gradeInWords = "Poor";
        } else if (grade >= 3.5 && grade < 4.5) {
            gradeInWords = "Good";
        } else if (grade >= 4.5 && grade < 5.5) {
            gradeInWords = "Very good";
        } else if (grade >= 5.5 && grade <= 6) {
            gradeInWords = "Excellent";
        }
        System.out.println(gradeInWords);

    }

}
