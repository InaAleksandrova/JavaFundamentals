package finalExamPreparation_24Jul2019;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption_80_100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^(?<artist>[A-Z '][a-z ']+):(?<song>[A-Z ]+)";
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);


        while (!"end".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String artistSongs = matcher.group();
                String artist = matcher.group("artist");
                StringBuilder encrypted = new StringBuilder();
                int key = artist.length();
                for (int i = 0; i < artistSongs.length(); i++) {
                    char current = input.charAt(i);
                    if (current == 32) {
                        encrypted.append(" ");
                    } else if (current == 58) {
                        encrypted.append("@");
                    } else if (current == 39) {
                        encrypted.append("'");
                    }

                    if (current != 32 && current != 58) {
                        current += key;
                        if (current >= 97 && current <= 122) {
                            encrypted.append(current);
                        } else if (current >= 65 && current <= 90) {
                            encrypted.append(current);
                        } else if (current > 122 && Character.isLowerCase(current)) {
                            char chr = (char) (97 - 1 + current % 122);
                            encrypted.append(chr);
                        } else if (current > 90 && Character.isUpperCase(current)) {
                            char chr = (char) (65 - 1 + current % 90);
                            encrypted.append(chr);
                        }
                    }
                }
                System.out.println("Successful encryption: " + encrypted);
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }

    }
}
