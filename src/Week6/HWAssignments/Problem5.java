package Week6.HWAssignments;

// Problem 5: Numbers, Referral Codes & Weekly Settlement
class P5GymMember {
    private static int nextMembershipId = 2001;
    private static int membersEnrolled = 0;

    protected final int membershipNumber;
    protected final String memberId;
    protected int monthlyFee;
    private int feesPaid = 0;

    public P5GymMember(int monthlyFee) {
        this.membershipNumber = nextMembershipId++;
        this.memberId = "GYM-" + this.membershipNumber;
        this.monthlyFee = monthlyFee;
        membersEnrolled++;
    }

    public int getMembershipNumber() {
        return membershipNumber;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public void payFee(int amount) {
        this.feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        payFee(amount); // Reuses 1-argument version internally
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        return code.charAt(0) == 'G' &&
                Character.isDigit(code.charAt(1)) &&
                Character.isDigit(code.charAt(2)) &&
                Character.isUpperCase(code.charAt(3));
    }

    public static String processWeeklyCheckIn(P5GymMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        if (members != null) {
            for (P5GymMember member : members) {
                if (member == null) {
                    nullSkipped++;
                    continue;
                }
                processed++;
                if (member instanceof P5GroupClassMember) {
                    groupCount++;
                } else {
                    individualCount++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " +
                groupCount + " group " + individualCount + " individual";
    }
}

class P5GroupClassMember extends P5GymMember {
    private String className;

    public P5GroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }
}

public class Problem5 {
    public static void main(String[] args) {
        // Auto ID Generation & Enrollment Count
        P5GymMember m1 = new P5GymMember(1000);
        System.out.println("GYM-" + m1.getMembershipNumber()); // Output: GYM-2001
        System.out.println(P5GymMember.getMembersEnrolled());  // Output: 1

        // Referral Code Validation
        System.out.println(P5GymMember.isValidReferralCode("G45B")); // true
        System.out.println(P5GymMember.isValidReferralCode("G4B"));  // false
        System.out.println(P5GymMember.isValidReferralCode("X45B")); // false

        // Fee Payment Overloads
        m1.payFee(500);
        m1.payFee(500, "UPI");
        System.out.println(m1.getFeesPaid()); // Output: 1000

        // Weekly Check-in Settlement
        P5GymMember[] checkIns = {
                new P5GroupClassMember(1500, "Zumba"),
                null,
                new P5GymMember(1000)
        };
        System.out.println(P5GymMember.processWeeklyCheckIn(checkIns));
        // Output: 2 processed | 1 null skipped | 1 group 1 individual
    }
}
