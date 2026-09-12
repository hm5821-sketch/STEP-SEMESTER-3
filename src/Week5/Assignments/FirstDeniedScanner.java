package Week5.Assignments;

public class FirstDeniedScanner {

    public static String firstDeniedAttempt(String[][] attempts) {
        if (attempts == null) {
            return "None Denied";
        }

        for (int i = 0; i < attempts.length; i++) {
            if (attempts[i] == null || attempts[i].length < 2) continue;
            String modifier = attempts[i][0];
            String context = attempts[i][1];

            if (!isAccessAllowed(modifier, context)) {
                return modifier + " via " + context + " (attempt #" + (i + 1) + ")";
            }
        }

        return "None Denied";
    }

    private static boolean isAccessAllowed(String fieldModifier, String accessorContext) {
        if ("public".equals(fieldModifier) || "SAME_CLASS".equals(accessorContext)) {
            return true;
        }
        if ("private".equals(fieldModifier)) {
            return false;
        }
        if ("SAME_PACKAGE".equals(accessorContext)) {
            return true;
        }
        if ("default".equals(fieldModifier)) {
            return false;
        }
        // Protected modifier rules
        if ("protected".equals(fieldModifier)) {
            return "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext);
        }

        return false;
    }
}
