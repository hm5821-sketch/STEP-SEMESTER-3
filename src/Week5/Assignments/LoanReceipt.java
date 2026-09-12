package Week5.Assignments;

// Base Immutable Class
public class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        // Defensive copying on construction
        if (bookIds != null) {
            this.bookIds = new String[bookIds.length];
            for (int i = 0; i < bookIds.length; i++) {
                this.bookIds[i] = bookIds[i];
            }
        } else {
            this.bookIds = new String[0];
        }
    }

    public String getMemberId() {
        return memberId;
    }

    // Defensive copying on getter
    public String[] getBookIds() {
        String[] copy = new String[this.bookIds.length];
        for (int i = 0; i < this.bookIds.length; i++) {
            copy[i] = this.bookIds[i];
        }
        return copy;
    }

    // Wither pattern for returning a new modified immutable instance
    public LoanReceipt withCorrectedBookId(int index, String newId) {
        if (index < 0 || index >= this.bookIds.length) {
            return this;
        }
        String[] updatedBookIds = getBookIds();
        updatedBookIds[index] = newId;
        return new LoanReceipt(this.memberId, updatedBookIds);
    }
}

// Subclass for Reference-Only Books
class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}

// Nightly Processor Class
class CirculationLedger {
    private static String branchCode;

    // Static initialization block
    static {
        branchCode = "BRANCH-MAIN-01";
    }

    public static String getBranchCode() {
        return branchCode;
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int nullCount = 0;
        int referenceCount = 0;
        int regularCount = 0;

        if (receipts != null) {
            for (LoanReceipt receipt : receipts) {
                if (receipt == null) {
                    nullCount++;
                } else if (receipt instanceof ReferenceOnlyLoanReceipt) {
                    referenceCount++;
                } else {
                    regularCount++;
                }
            }
        }

        int totalProcessed = referenceCount + regularCount;
        return totalProcessed + " processed | " + nullCount + " null skipped | " +
                referenceCount + " reference-only | " + regularCount + " regular";
    }
}
