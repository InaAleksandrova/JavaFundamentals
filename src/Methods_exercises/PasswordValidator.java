package Methods_exercises;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (!checkPasswordLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if(!checkPasswordHasNoSpecialChars(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!checkPasswordHasMinTwoDigits(password)) {
            System.out.println("Password must have at least 2 digits");
        }
        if (checkPasswordLength(password) && checkPasswordHasMinTwoDigits(password) && checkPasswordHasNoSpecialChars(password)) {
            System.out.println("Password is valid");
        }
    }

    public static boolean checkPasswordLength(String password) {
        if ((password.length() < 6) || (password.length() > 10)) {
           boolean validLength = false;
        } else {
            return true;
        }
        return false;
    }

    public static boolean checkPasswordHasNoSpecialChars(String password) {
        boolean letterOrDigit = false;
        char currentSymbol = password.charAt(0);
        for (int i = 0; i < password.length(); i++) {
            letterOrDigit = Character.isLetterOrDigit(currentSymbol);
            currentSymbol = password.charAt(i);
        }

        return letterOrDigit;
    }

    public static boolean checkPasswordHasMinTwoDigits(String password){
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);
            boolean digits = Character.isDigit(currentSymbol);
            if (digits) {
                counter++;
                if (counter < 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
