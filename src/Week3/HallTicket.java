package Week3;

public class HallTicket {
    String studentName;
    int seatNumber;
    HallTicket(String studentName, int seatNumber)
    {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
    public static void main(String [] args)
    {
        HallTicket priya = new HallTicket("Priya",0);
        HallTicket copy = priya;
        copy.seatNumber = 45;
        System.out.println("Priya's Seat Number :" + priya.seatNumber);
        System.out.println("copy == priya  " + (copy == priya));
        HallTicket seperate = new HallTicket("Priya",45);
        System.out.println("seperate == priya " + (seperate == priya));
    }
}
