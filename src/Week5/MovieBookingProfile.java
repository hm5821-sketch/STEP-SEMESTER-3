package Week5;

public class MovieBookingProfile {
    private String name;
    private boolean confirmed;
    private String otp;

    // Public no-arg constructor[cite: 1]
    public MovieBookingProfile() {
    }

    // Convenience constructor using this(...)[cite: 1]
    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    // Write-only OTP setter (no getter exists)[cite: 1]
    public void setOtp(String otp) {
        this.otp = otp;
    }
}
