package Week2;

import java.util.Scanner;

public class BankReferenceValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }

        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String bankCode = reference.substring(0, 3);
        String datePart = reference.substring(3, 9);
        String seqPart = reference.substring(9, 14);

        String day = datePart.substring(0, 2);
        String month = datePart.substring(2, 4);
        String year = datePart.substring(4, 6);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ")
                .append("DATE: ").append(day).append("/").append(month).append("/").append(year)
                .append(" | SEQ: ").append(seqPart);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String normalized = normalizeReference(input);
        String result = validateAndFormat(normalized);

        System.out.println(result);
        scanner.close();
    }
}
