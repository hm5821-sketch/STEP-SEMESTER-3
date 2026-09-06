package Week1.HWAssignments;

public class WordLengthProfiler {

    public static void classifyWordLengths(String review) {
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        String[] words = review.split("\\s+");

        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanWord.isEmpty()) continue;

            int len = cleanWord.length();
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d\n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        // Test Case
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}