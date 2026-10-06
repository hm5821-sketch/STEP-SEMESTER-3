package Week6;

public class NightlyAudit {

    static class LibraryMember {
        private static int membersEnrolledCount = 0;

        public final String memberNumber;
        protected int borrowLimit;
        protected int booksBorrowed;

        public LibraryMember(int borrowLimit) {
            membersEnrolledCount++;
            this.memberNumber = "LIB-" + (100 + membersEnrolledCount);
            this.borrowLimit = borrowLimit;
            this.booksBorrowed = 0;
        }

        public static int getMembersEnrolled() {
            return membersEnrolledCount;
        }

        public void borrowBook() {
            booksBorrowed++;
        }

        public void borrowBook(String genre) {
            borrowBook();
        }

        public int getBooksBorrowed() {
            return booksBorrowed;
        }
    }

    static class FacultyMember extends LibraryMember {
        private String department;

        public FacultyMember(int borrowLimit, String department) {
            super(borrowLimit);
            this.department = department;
        }
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        if (code.charAt(0) != 'R') {
            return false;
        }
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) {
            return false;
        }
        return Character.isUpperCase(code.charAt(3));
    }

    public static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int facultyCount = 0;
        int regularCount = 0;

        for (LibraryMember member : members) {
            if (member == null) {
                nullSkipped++;
            } else {
                processed++;
                if (member instanceof FacultyMember) {
                    facultyCount++;
                } else {
                    regularCount++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + facultyCount + " faculty " + regularCount + " regular";
    }
}