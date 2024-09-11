import java.security.SecureRandom;
import java.util.Scanner;

public class RandomPasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("yes");

        String characterSet = "";
        if (includeNumbers) {
            characterSet += DIGITS;
        }
        if (includeLowercase) {
            characterSet += LOWERCASE;
        }
        if (includeUppercase) {
            characterSet += UPPERCASE;
        }
        if (includeSpecialChars) {
            characterSet += SPECIAL_CHARS;
        }

        if (characterSet.isEmpty()) {
            System.out.println("No character types selected. Exiting.");
            scanner.close();
            return;
        }

        String password = generatePassword(length, characterSet);
        System.out.println("Generated password: " + password);

        scanner.close();
    }

    private static String generatePassword(int length, String characterSet) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }

        return password.toString();
    }
}
