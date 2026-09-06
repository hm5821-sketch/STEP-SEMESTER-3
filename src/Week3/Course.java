package Week3;

public class Course {
    String code;
    String title ;
    int credits;
    int lab_credits;
    Course (String code, String title,int credits,int lab_credits)
    {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.lab_credits = lab_credits;
    }
    Course (String code, String title,int credits)
    {
        this(code,title,credits,0);
    }
    int totalCredits()
    {
        return lab_credits + credits;
    }
    public static void main (String[] args)
    {
        Course c1 = new Course("21CSC201J","Data Structures",4);
        Course c2 = new Course ("21CSC205L","DSA Lab",3,1);
        System.out.println(c1.code +" " + "Total Credits " + c1.totalCredits());
        System.out.println(c2.code +" " + "Total Credits " + c2.totalCredits());
    }
}
