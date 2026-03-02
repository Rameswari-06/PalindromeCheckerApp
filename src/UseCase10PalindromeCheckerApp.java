import java.util.Scanner;

// Palindrome Checker with Case & Space Ignored
class PalindromeChecker {

    public boolean checkPalindrome(String input) {

        // Step 1: Normalize string (ignore spaces & case)
        String normalized = input
                .replaceAll("\\s+", "")
                .toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        // Step 2: Palindrome check
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

// Main Application Class
public class UseCase10PalindromeCheckerApp {

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