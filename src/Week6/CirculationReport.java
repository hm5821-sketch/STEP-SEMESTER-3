package Week6;

public class CirculationReport {

    static class LibraryMember {
        protected String memberId;
        protected int borrowLimit;
        protected int booksBorrowed;

        public LibraryMember(String memberId, int borrowLimit) {
            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
            this.booksBorrowed = 0;
        }

        public String displayInfo() {
            return "General | Books: " + booksBorrowed;
        }
    }

    static class StudentMember extends LibraryMember {
        private String course;

        public StudentMember(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
            this.course = course;
        }

        public String getCourse() {
            return course;
        }

        @Override
        public String displayInfo() {
            return "Student | Course: " + course + " | Books: " + booksBorrowed;
        }
    }

    public static String batchPrint(LibraryMember[] members) {
        StringBuilder sb = new StringBuilder();

        for (LibraryMember member : members) {
            sb.append(member.displayInfo());

            if (member instanceof StudentMember) {
                StudentMember sm = (StudentMember) member;
                sb.append(" [Course via downcast: ").append(sm.getCourse()).append("]");
            }

            sb.append(" | ");
        }

        return sb.toString();
    }
}
