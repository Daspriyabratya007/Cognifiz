import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password to check its strength: ");
        String password = scanner.nextLine();

        String strength = checkPasswordStrength(password);

        System.out.println("Password Strength: " + strength);

        scanner.close();
    }

    private static String checkPasswordStrength(String password) {
        if (password.length() < 8) {
            return "Weak: Password is too short.";
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        if (hasUppercase && hasLowercase && hasDigit && hasSpecial) {
            return "Strong: Password meets all criteria.";
        } else if (hasUppercase && hasLowercase && hasDigit) {
            return "Moderate: Password could be improved by adding special characters.";
        } else if (hasUppercase && hasLowercase) {
            return "Weak: Password could be improved by adding digits and special characters.";
        } else {
            return "Very Weak: Password should include uppercase letters, lowercase letters, digits, and special characters.";
        }
    }
}
