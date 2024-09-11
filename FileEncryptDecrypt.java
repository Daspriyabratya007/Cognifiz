import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryptDecrypt {

    private static final int SHIFT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose an option (encrypt/decrypt): ");
        String option = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter the file name or path: ");
        String filePath = scanner.nextLine().trim();

        if ("encrypt".equals(option)) {
            processFile(filePath, true);
        } else if ("decrypt".equals(option)) {
            processFile(filePath, false);
        } else {
            System.out.println("Invalid option. Please choose 'encrypt' or 'decrypt'.");
        }

        scanner.close();
    }

    private static void processFile(String filePath, boolean encrypt) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("output_" + (encrypt ? "encrypted" : "decrypted") + ".txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String processedLine = encrypt ? encrypt(line) : decrypt(line);
                writer.write(processedLine);
                writer.newLine();
            }

            System.out.println("File has been " + (encrypt ? "encrypted" : "decrypted") + " and saved as output_"
                    + (encrypt ? "encrypted" : "decrypted") + ".txt");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static String encrypt(String text) {
        return processText(text, SHIFT);
    }

    private static String decrypt(String text) {
        return processText(text, -SHIFT);
    }

    private static String processText(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char i : text.toCharArray()) {
            if (Character.isLetter(i)) {
                char base = Character.isUpperCase(i) ? 'A' : 'a';
                result.append((char) ((i - base + shift + 26) % 26 + base));
            } else {
                result.append(i);
            }
        }
        return result.toString();
    }
}
