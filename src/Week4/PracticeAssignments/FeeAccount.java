package Week4.PracticeAssignments;

class FeeAccount {
}

class HostelFeeAccount extends FeeAccount {
}

class PaymentProcessor {
    private int hostelCount = 0;
    private int dayScholarCount = 0;

    public void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            System.out.println("Paid in two installments (hostel account)");
            hostelCount++;
        } else if (account instanceof FeeAccount) {
            System.out.println("Paid in one go (day-scholar account)");
            dayScholarCount++;
        }
    }

    public void printSummary() {
        System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount);
    }
public static void main(String[] args) {
        FeeAccount[] accounts = {
                new HostelFeeAccount(),
                new HostelFeeAccount(),
                new FeeAccount(),
                new FeeAccount()
        };

        PaymentProcessor processor = new PaymentProcessor();
        double amount = 60000;

        for (FeeAccount account : accounts) {
            processor.processPayment(account, amount);
        }

        processor.printSummary();
    }
}
