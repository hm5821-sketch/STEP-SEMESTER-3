package Week6.HWAssignments;

import java.util.Arrays;

// Problem 1: Basic Gym Membership & Batch Validator
class P1GymMember {
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended = 0;

    public P1GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("Construction rejected: Invalid Member ID");
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public void attendSession() {
        this.sessionsAttended++;
    }

    public int getSessionsAttended() {
        return this.sessionsAttended;
    }

    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;

        for (String id : memberIds) {
            try {
                new P1GymMember(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Signed Up: " + signedUp + " Rejected: " + rejected;
    }
}

class P1PremiumMember extends P1GymMember {
    private String trainerName;

    public P1PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        // Test Case 1: Rejected Construction
        try {
            new P1GymMember("GM1", 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }

        // Test Case 2: Premium Member Sessions
        P1PremiumMember p = new P1PremiumMember("MEM01", 2000, "Coach Riya");
        p.attendSession();
        p.attendSession();
        System.out.println(p.getSessionsAttended()); // Output: 2

        // Test Case 3: Batch Sign-Up
        String[] batch = {"MEM1", "GM1", "MEM2", "", "MEM3"};
        System.out.println(P1GymMember.signUpBatch(batch, 1000));
        // Output: Signed Up: 3 Rejected: 2
    }
}