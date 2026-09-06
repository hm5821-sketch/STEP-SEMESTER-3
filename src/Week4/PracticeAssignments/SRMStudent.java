package Week4.PracticeAssignments;

class SrmStudent {
    static String collegeName;
    static String academicYear;
    private String name;

    static {
        collegeName = "SRM";
        academicYear = "2026";
        System.out.println("College info loaded");
    }

    public SrmStudent(String name) {
        this.name = name;
        System.out.println("Student record created: " + name);
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        for (String name : names) {
            new SrmStudent(name);
        }
    }
}