package Week2;

import java.util.Scanner;

public class PhoneMasker {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String lastFourDigits = phone.substring(6);
        StringBuilder sb = new StringBuilder("XXXXXX");
        sb.insert(6, "-");
        sb.append(lastFourDigits);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(maskPhoneNumber(input));
        scanner.close();
    }
}
