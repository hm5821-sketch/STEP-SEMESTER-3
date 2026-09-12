package Week5;

public class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        // Defensive copy using plain array loop[cite: 1]
        if (seatNumbers != null) {
            this.seatNumbers = new String[seatNumbers.length];
            for (int i = 0; i < seatNumbers.length; i++) {
                this.seatNumbers[i] = seatNumbers[i];
            }
        } else {
            this.seatNumbers = new String[0];
        }
    }

    public String getBookingId() {
        return bookingId;
    }

    public String[] getSeatNumbers() {
        // Defensive copy on output[cite: 1]
        String[] copy = new String[seatNumbers.length];
        for (int i = 0; i < seatNumbers.length; i++) {
            copy[i] = seatNumbers[i];
        }
        return copy;
    }

    // Creates a new modified receipt (Wither pattern)[cite: 1]
    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        if (index < 0 || index >= this.seatNumbers.length) {
            return this;
        }
        String[] updatedSeats = getSeatNumbers();
        updatedSeats[index] = newSeat;
        return new BookingReceipt(this.bookingId, updatedSeats);
    }

    // Subclass for group bookings[cite: 1]
    public static class GroupBookingReceipt extends BookingReceipt {
        private final int groupSize;

        public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
            super(bookingId, seatNumbers);
            this.groupSize = groupSize;
        }

        public int getGroupSize() {
            return groupSize;
        }
    }

    public static String processNightlySettlement(BookingReceipt[] receipts) {
        if (receipts == null) {
            return "0 processed | 0 null skipped\n0 group | 0 individual";
        }

        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        for (int i = 0; i < receipts.length; i++) {
            if (receipts[i] == null) {
                nullSkipped++; // Null safety check[cite: 1]
            } else {
                processed++;
                if (receipts[i] instanceof GroupBookingReceipt) { // Class checking[cite: 1]
                    groupCount++;
                } else {
                    individualCount++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped\n" +
                groupCount + " group | " + individualCount + " individual";
    }
}
