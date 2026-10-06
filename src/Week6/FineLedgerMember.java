package Week6;

import java.util.Arrays;

public class FineLedgerMember {
    protected String memberId;
    protected int borrowLimit;
    private int[] fineHistory;
    private int fineCount;

    public FineLedgerMember(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.fineHistory = new int[10];
        this.fineCount = 0;
    }

    protected void chargeFine(int amount) {
        if (fineCount < fineHistory.length) {
            fineHistory[fineCount++] = amount;
        }
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        int total = 0;
        for (int i = 0; i < fineCount; i++) {
            total += fineHistory[i];
        }
        return total;
    }
}

class StudentFineMember extends FineLedgerMember {
    private String course;

    public StudentFineMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}
