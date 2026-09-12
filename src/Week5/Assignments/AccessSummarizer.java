package Week5.Assignments;

 class LibraryMember {
    // Requirements:
    // private: inaccessible outside this class
    private String membershipPin;

    // default (package-private): reachable only within the same package
    String branchCode;

    // protected: reachable by same package (and subclasses in other packages)
    protected double finesOwed;

    // public: reachable from anywhere
    public String displayName;

    public LibraryMember(String membershipPin, String branchCode, double finesOwed, String displayName) {
        this.membershipPin = membershipPin;
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }
}

public class AccessSummarizer {

    public static String summarizeByModifier(String[][] attempts) {
        int privateAllowed = 0, privateDenied = 0;
        int defaultAllowed = 0, defaultDenied = 0;
        int protectedAllowed = 0, protectedDenied = 0;
        int publicAllowed = 0, publicDenied = 0;

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt == null || attempt.length < 2) continue;
                String modifier = attempt[0];
                String context = attempt[1];

                boolean isAllowed = isAccessAllowed(modifier, context);

                switch (modifier) {
                    case "private":
                        if (isAllowed) privateAllowed++; else privateDenied++;
                        break;
                    case "default":
                        if (isAllowed) defaultAllowed++; else defaultDenied++;
                        break;
                    case "protected":
                        if (isAllowed) protectedAllowed++; else protectedDenied++;
                        break;
                    case "public":
                        if (isAllowed) publicAllowed++; else publicDenied++;
                        break;
                }
            }
        }

        return "private: " + privateAllowed + " allowed / " + privateDenied + " denied " +
                "default: " + defaultAllowed + " allowed / " + defaultDenied + " denied " +
                "protected: " + protectedAllowed + " allowed / " + protectedDenied + " denied " +
                "public: " + publicAllowed + " allowed / " + publicDenied + " denied";
    }

    private static boolean isAccessAllowed(String fieldModifier, String accessorContext) {
        if ("public".equals(fieldModifier) || "SAME_CLASS".equals(accessorContext)) {
            return true;
        }
        if ("private".equals(fieldModifier) || "DIFFERENT_PACKAGE".equals(accessorContext)) {
            return false;
        }
        return "SAME_PACKAGE".equals(accessorContext);
    }
}