import java.util.Scanner;

// Service class: Encapsulates palindrome logic
class PalindromeChecker {

    // Public method exposed to clients
    public boolean checkPalindrome(String input) {

        // Normalize input: remove spaces & make lowercase
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        int length = cleaned.length();
        char[] stack = new char[length];
        int top = -1;

        // Push characters into stack
        for (int i = 0; i < length; i++) {
            stack[++top] = cleaned.charAt(i);
        }

        // Pop and compare with original string
        for (int i = 0; i < length; i++) {
            if (cleaned.charAt(i) != stack[top--]) {
                return false;
            }
        }

        return true;
    }
}

// Main application class
public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter a string to check palindrome: ");
        String input = scanner.nextLine();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("Result: The given string IS a palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a palindrome.");
        }

        scanner.close();
    }
}