package Week7;

abstract class DeliveryNote {
    protected String trackingId;

    public DeliveryNote(String trackingId) {
        this.trackingId = trackingId;
    }

    public abstract String confirmDelivery();

    public String confirmDelivery(String signature) {
        return confirmDelivery() + ", signed by " + signature;
    }

    public static void logAll(DeliveryNote[] notes) {
        for (DeliveryNote note : notes) {
            System.out.println(note.confirmDelivery());
        }
    }
}

class ParcelNote extends DeliveryNote {
    public ParcelNote(String trackingId) {
        super(trackingId);
    }

    @Override
    public String confirmDelivery() {
        return "Parcel " + trackingId + " delivered";
    }
}

class LetterNote extends DeliveryNote {
    public LetterNote(String trackingId) {
        super(trackingId);
    }

    @Override
    public String confirmDelivery() {
        return "Letter " + trackingId + " delivered";
    }
}

public class Problem5 {
    public static void main(String[] args) {
        ParcelNote p = new ParcelNote("TRK-1");
        System.out.println(p.confirmDelivery());                    // Output: Parcel TRK-1 delivered
        System.out.println(p.confirmDelivery("J. Smith"));          // Output: Parcel TRK-1 delivered, signed by J. Smith

        DeliveryNote ref = p; // Upcasting
        DeliveryNote.logAll(new DeliveryNote[] { ref, new LetterNote("TRK-2") });
        // Output:
        // Parcel TRK-1 delivered
        // Letter TRK-2 delivered
    }
}
