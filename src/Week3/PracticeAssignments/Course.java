package Week3.PracticeAssignments;

public class Course {
    String code;
    String title;
    int credits;
    int labCredits;

    // 4-argument constructor setting all fields directly
    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // 3-argument constructor for theory-only, chaining to 4-argument constructor via this()
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    // Returns sum of theory and lab credits
    public int totalCredits() {
        return credits + labCredits;
    }

    public static void main(String[] args) {
        Course course1 = new Course("21CSC201J", "Data Structures", 4);
        Course course2 = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(course1.code + " total credits:\n" + course1.totalCredits());
        System.out.println(course2.code + " total credits:\n" + course2.totalCredits());
    }
}
