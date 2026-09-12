package Week5;

public class AccessCheckers {

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("public".equals(fieldModifier)) {
            return "ALLOWED";
        }
        if ("protected".equals(fieldModifier)) {
            // Evaluates cross-package inheritance scenarios[cite: 1]
            if ("SAME_CLASS".equals(accessorContext) ||
                    "SAME_PACKAGE".equals(accessorContext) ||
                    "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext)) {
                return "ALLOWED";
            }
            return "DENIED";
        }
        if ("default".equals(fieldModifier)) {
            if ("SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext)) {
                return "ALLOWED";
            }
            return "DENIED";
        }
        if ("private".equals(fieldModifier)) {
            if ("SAME_CLASS".equals(accessorContext)) {
                return "ALLOWED";
            }
            return "DENIED";
        }
        return "DENIED";
    }
}