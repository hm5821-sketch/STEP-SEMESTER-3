package Week1.HWAssignments;

public class SeatChecker {
    public void checkDuplicateSeats(int[] seatNumbers) {
        boolean hasDuplicate = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    hasDuplicate = true;
                    break; // Prevents logging the same duplicate pair multiple times
                }
            }
        }

        if (!hasDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}

