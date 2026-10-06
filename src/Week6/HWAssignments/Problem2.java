package Week6.HWAssignments;

// Problem 2: Three Tiers of Gym Membership & Polymorphism
class P2GymMember {
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended = 0;

    public P2GymMember(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public void attendSession() {
        this.sessionsAttended++;
    }

    public int getSessionsAttended() {
        return this.sessionsAttended;
    }

    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }

    public static String classifyGeneration(P2GymMember member) {
        if (member instanceof P2EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof P2GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof P2PremiumMember) {
            return "Direct subclass";
        } else {
            return "Base Class";
        }
    }

    public static int getTotalSessionsAttended(P2GymMember[] members) {
        int total = 0;
        for (P2GymMember member : members) {
            if (member != null) {
                total += member.getSessionsAttended();
            }
        }
        return total;
    }
}

class P2PremiumMember extends P2GymMember {
    protected String trainerName;

    public P2PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium Member Trainer: " + trainerName + " Sessions: " + getSessionsAttended();
    }
}

class P2EliteMember extends P2PremiumMember {
    private String lockerNumber;

    public P2EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    public String displayInfo() {
        return "Elite Member Trainer: " + trainerName + " | Locker: " + lockerNumber + " | Sessions: " + getSessionsAttended();
    }
}

class P2GroupClassMember extends P2GymMember {
    private String className;

    public P2GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    public String displayInfo() {
        return "Group Class Member Class: " + className + " Sessions: " + getSessionsAttended();
    }
}

public class Problem2 {
    public static void main(String[] args) {
        // Display Info Tests
        System.out.println(new P2GymMember("MEM1", 1000).displayInfo());
        System.out.println(new P2PremiumMember("MEM2", 2000, "Coach Riya").displayInfo());
        System.out.println(new P2EliteMember("MEM3", 3000, "Coach Arjun", "L12").displayInfo());
        System.out.println(new P2GroupClassMember("MEM4", 1500, "Zumba").displayInfo());

        // Classification Tests
        P2EliteMember eliteMember = new P2EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        P2GroupClassMember groupClassMember = new P2GroupClassMember("MEM4", 1500, "Zumba");

        System.out.println(P2GymMember.classifyGeneration(eliteMember));
        System.out.println(P2GymMember.classifyGeneration(groupClassMember));

        // Total Sessions Attended Test
        P2PremiumMember premiumMember = new P2PremiumMember("MEM2", 2000, "Coach Riya");
        for (int i = 0; i < 3; i++) premiumMember.attendSession();
        for (int i = 0; i < 2; i++) eliteMember.attendSession();
        for (int i = 0; i < 4; i++) groupClassMember.attendSession();

        P2GymMember[] members = { premiumMember, eliteMember, groupClassMember };
        System.out.println(P2GymMember.getTotalSessionsAttended(members)); // Output: 9
    }
}
