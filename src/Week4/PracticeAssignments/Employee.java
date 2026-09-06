package Week4.PracticeAssignments;

class Employee {
    private String id;
    private double salary;

    public Employee(String id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary += salary;
    }

    public void printSalary() {
        System.out.println(id + " | Final Salary: Rs " + salary);
    }


    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("E-101", 40000),
                new Employee("E-102", 55000),
                new Employee("E-103", 62000),
                new Employee("E-104", 48000)
        };

        double festivalBonus = 5000;

        for (Employee emp : employees) {
            emp.raiseSalary(festivalBonus);
            emp.printSalary();
        }
    }
}

