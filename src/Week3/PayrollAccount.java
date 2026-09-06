package Week3;

public class PayrollAccount {
    private double basicSalary;
    private double bonus;
    public PayrollAccount(double basicSalary)
    {
        if(basicSalary < 0)
        {
            System.out.println("Warning:Basic Salary cannot be negative");
            this.basicSalary = 0;
        }
        else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0;
    }
    public void creditBonus(double amount)
    {
        if (amount <= 0 )
        {
            System.out.println("Error: Bonus amount must be greater than 0");
        } else
        {
            this.bonus += amount;
            System.out.println("Bonus Credited : " + bonus);
        }
    }
    public void deductTax (double percentage)
    {
        if (percentage < 0 || percentage > 100)
        {
            System.out.println("Error : Tax Percentage must be between 0 and 100");
        } else {
            double deduction = this.basicSalary * (percentage / 100);
            this.basicSalary -= deduction ;
            System.out.println("Tax Deducted :" + (int) percentage + "%");
        }
    }
    public double getNetSalary ()
    {
        return this.basicSalary + this.bonus;
    }
    public static void main(String[] args)
    {
        PayrollAccount account = new PayrollAccount(5000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net Salary : Rs"+account.getNetSalary());
    }
}
