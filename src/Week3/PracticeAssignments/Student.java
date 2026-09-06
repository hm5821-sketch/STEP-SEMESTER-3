package Week3.PracticeAssignments;

public class Student {
    // Instance fields unique to each student
    String name;
    double attendance;

    // Static fields shared across all student instances
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    // Constructor increments static student count
    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    // Static method printing shared info without referencing instance fields
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Ravi", 85.0);
        Student s2 = new Student("Anitha", 92.0);

        // Accessing static method via the class name
        Student.printCollegeInfo();
    }
}