public class Account {

    /**
     * Class variable for maintaining the last account number used.
     */
    private static int lastId = 0;
    /**
     * The unique account number assigned by the default constructor.
     */
    private final int id;

    private String firstName;

    private String lastName;

    private double balance;


    public Account() {
        id = ++lastId;
    }

    public int getId() {
        return id;

    }

    public Account(String firstName, String lastName) {


    }

    public double getBalance() {
        return balance;
    }

    /**
     * Allow setting of the account owner's first name.
     * @param firstName The account owners first name.
     * @throws IllegalArgumentException Invalid first name! First name cant be null or empty for id: 1.
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException ("Invalid first name! " + "Name can't be blank for id: " + id);
        else
            this.firstName = firstName;
    }

    /**
     * Allow setting of the account owner's last name.
     * @param lastName The account owners first name.
     * @throws IllegalArgumentException Invalid last name! Last name cant be null or empty for id: 1.
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty())
            throw new IllegalArgumentException ("Invalid last name! " + "Name can't be blank for id: " + id);
        else
            this.lastName = lastName;
    }

    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException ("Invalid amount [-100.00]. Must be greater than 0.");
        else
            balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance)
            throw new IllegalArgumentException("Invalid amount [-100.00]. Must be greater than 0.");
        throw new IllegalArgumentException("Invalid amount [-500.00]. Cannot be greater than the account balance [100.00].");

        balance -= amount;
    }

}
