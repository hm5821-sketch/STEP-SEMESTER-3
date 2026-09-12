package Week5;

public class CineScreen {
    private int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {
        // Reject invalid initial seat totals[cite: 1]
        if (seatsTotal <= 0) {
            System.out.println("construction rejected");
            return;
        }
        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    public void bookSeat() {
        // Prevent seatsAvailable from falling below zero[cite: 1]
        if (seatsAvailable > 0) {
            seatsAvailable--;
        }
    }

    public void cancelBooking() {
        // Prevent seatsAvailable from exceeding total capacity[cite: 1]
        if (seatsAvailable < seatsTotal) {
            seatsAvailable++;
        }
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }
}
