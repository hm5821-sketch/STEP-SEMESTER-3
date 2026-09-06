package Week1.HWAssignments;

public class SignalAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) return;

        int maxStreak = 1;
        char maxChar = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    maxChar = signalLog.charAt(i - 1);
                }
                currentStreak = 1;
            }
        }

        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            maxChar = signalLog.charAt(signalLog.length() - 1);
        }

        System.out.println("Longest Streak: '" + maxChar + "' repeated " + maxStreak + " times");
    }

    public static void main(String[] args) {
        // Test Cases
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}