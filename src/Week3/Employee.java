package Week3;

public class Employee {
    String  empId;
    String empName;
    double salary;
    boolean isIntern;
    public Employee (String empId,String empName,double salary)
    {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        isIntern = false;
    }
    public Employee (String empId,String empName)
    {
        this(empId,empName,0);
        isIntern = true;
    }
    void PrintProfile()
    {
        System.out.println(empId + " | " +empName + " | " + "Rs " + salary + " | " + "Intern : " + isIntern );
    }

    public static void main() {
        Employee Permanent = new Employee("E-101","Divya",65000.0);
        Employee Intern = new Employee("E-102","Arjun");
        Permanent.PrintProfile();
        Intern.PrintProfile();
    }
}
