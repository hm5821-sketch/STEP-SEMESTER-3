package Week6.HWAssignments;

// Problem 4: Monthly Attendance Announcer
class P4GymMember {
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended = 0;

    public P4GymMember(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public static String batchPrint(P4GymMember[] members) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < members.length; i++) {
            P4GymMember m = members[i];

            if (m instanceof P4PremiumMember) {
                P4PremiumMember pm = (P4PremiumMember) m; // Safe downcast
                sb.append("Standard | Sessions: ").append(m.getSessionsAttended())
                        .append(" | Premium | Trainer: ").append(pm.getTrainerName())
                        .append(" | Sessions: ").append(pm.getSessionsAttended())
                        .append(" [Trainer via downcast: ").append(pm.getTrainerName()).append("]");
            } else {
                sb.append("Standard | Sessions: ").append(m.getSessionsAttended());
            }

            if (i < members.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
}

class P4PremiumMember extends P4GymMember {
    private String trainerName;

    public P4PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }
}

public class Problem4 {
    public static void main(String[] args) {
        P4GymMember[] batch = {
                new P4GymMember("MEM6", 1000),
                new P4PremiumMember("MEM7", 2000, "Coach Riya")
        };

        System.out.println(P4GymMember.batchPrint(batch));
    }
}
