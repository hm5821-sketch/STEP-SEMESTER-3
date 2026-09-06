package Week3.PracticeAssignments;

class IdCard {
    String name;
    int booksIssued;

    // Constructor to set name and booksIssued
    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        // Original reference
        IdCard ravi = new IdCard("Ravi", 0);

        // Shared reference pointing to the same object
        IdCard duplicate = ravi;

        // Modifying through second variable
        duplicate.booksIssued = 3;

        // Printing field value via first variable and reference comparison
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        // Third separate object with identical values
        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}