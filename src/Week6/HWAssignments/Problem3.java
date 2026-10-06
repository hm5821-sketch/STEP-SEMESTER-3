package Week6.HWAssignments;

import java.util.Arrays;

// Problem 3: Loyalty Discount & Late-Fee Ledger
class P3GymMember {
    protected String memberId;
    protected int monthlyFee;

    private int[] lateFeeHistory = new int[10];
    private int lateFeeCount = 0;

    public P3GymMember(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    protected void chargeLateFee(int amount) {
        if (lateFeeCount < lateFeeHistory.length) {
            lateFeeHistory[lateFeeCount++] = amount;
        }
    }

    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, lateFeeCount); // Defensive copy
    }

    public int getTotalLateFees() {
        int total = 0;
        for (int i = 0; i < lateFeeCount; i++) {
            total += lateFeeHistory[i];
        }
        return total;
    }
}

class P3PremiumMember extends P3GymMember {
    private String trainerName;

    public P3PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2); // 50% discount applied via super
    }
}

public class Problem3 {
    public static void main(String[] args) {
        P3PremiumMember p = new P3PremiumMember("MEM5", 2000, "Coach Riya");
        p.chargeLateFee(200);
        System.out.println(p.getTotalLateFees()); // Output: 100

        // Testing Defensive Copy
        int[] history = p.getLateFeeHistory();
        System.out.println(Arrays.toString(history)); // Output: [100]

        history[0] = 999; // Attempt tampering
        System.out.println(Arrays.toString(p.getLateFeeHistory())); // Output: [100]
    }
}
