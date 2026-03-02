import java.util.Scanner;

// Utility class containing different palindrome algorithms
class PalindromeAlgorithms {

    // Normalize input
    static String normalize(String input) {
        return input.replaceAll("\\s+", "").toLowerCase();
    }

    // Algorithm 1: Two-pointer approach
    static boolean twoPointerPalindrome(String input) {
        String s = normalize(input);
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Algorithm 2: Stack-based approach
    static boolean stackPalindrome(String input) {
        String s = normalize(input);
        int n = s.length();
        char[] stack = new char[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            stack[++top] = s.charAt(i);
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != stack[top--]) {
                return false;
            }
        }
        return true;
    }

    // Algorithm 3: Recursive approach
    static boolean recursivePalindrome(String input) {
        String s = normalize(input);
        return checkRecursive(s, 0, s.length() - 1);
    }

    private static boolean checkRecursive(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        return checkRecursive(s, start + 1, end - 1);
    }
}

// Main Application Class
public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check palindrome: ");
        String input = scanner.nextLine();

        long startTime, endTime;

        // Two-pointer
        startTime = System.nanoTime();
        boolean result1 = PalindromeAlgorithms.twoPointerPalindrome(input);
        endTime = System.nanoTime();
        long time1 = endTime - startTime;

        // Stack-based
        startTime = System.nanoTime();
        boolean result2 = PalindromeAlgorithms.stackPalindrome(input);
        endTime = System.nanoTime();
        long time2 = endTime - startTime;

        // Recursive
        startTime = System.nanoTime();
        boolean result3 = PalindromeAlgorithms.recursivePalindrome(input);
        endTime = System.nanoTime();
        long time3 = endTime - startTime;

        // Display Results
        System.out.println("\n--- Palindrome Check Results ---");
        System.out.println("Two-Pointer Result : " + result1);
        System.out.println("Stack Result       : " + result2);
        System.out.println("Recursive Result   : " + result3);

        System.out.println("\n--- Performance (nanoseconds) ---");
        System.out.println("Two-Pointer Time : " + time1);
        System.out.println("Stack Time       : " + time2);
        System.out.println("Recursive Time   : " + time3);

        scanner.close();
    }
}