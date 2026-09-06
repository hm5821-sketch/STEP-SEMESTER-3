package Week1.HWAssignments;

public class TypingChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int total = original.length();
        int firstMismatchIndex = -1;

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchIndex == -1) {
                firstMismatchIndex = i;
            }
        }

        double accuracy = (double) matched / total * 100;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", matched, total, accuracy);

        if (firstMismatchIndex == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.printf("First Mismatch at position %d ('%c' vs '%c')\n",
                    firstMismatchIndex + 1,
                    original.charAt(firstMismatchIndex),
                    typed.charAt(firstMismatchIndex));
        }
    }

    public static void main(String[] args) {
        // Test Cases
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
