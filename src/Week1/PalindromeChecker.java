package Week1;

public class PalindromeChecker {

    // Approach 1: Iterative Two-Pointer Check
    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void checkAndPrint(String text) {
        boolean result = isPalindromeIterative(text);
        if (result) {
            System.out.println(text + " -> Iterative: Palindrome");
        } else {
            System.out.println(text + " -> Iterative: Not Palindrome");
        }
    }

    public static void main(String[] args) {
        checkAndPrint("madam");
        checkAndPrint("hello");
    }
}