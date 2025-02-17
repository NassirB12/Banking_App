/**
 * @author Nassir Binion
 * @see https://github.com/NassirB12/Banking_App
 * @version
 * @since 2025.02.011
 */



public class Account {

    /**
     * Class variable for maintaining the last account number used.
     */
    private static int lastId = 0;

    /**
     * The unique account number assigned by the default constructor.
     */
    private int id;

    /**
     * The account owner's first name.
     */
    private String firstName;

    /**
     * The account owner's last name.
     */
    private String lastName;

    /**
     * The current account balance.
     */
    private double balance;

    /**
     * The default constructor sets a unique account id based on the last account id and
     * also sets all the initial values for instance level fields.
     */
    public Account() {
        id = ++lastId;
    }

    public int getId() {
        return id;

    }

    /**
     * The overload constructor calls the default constructor and the allows overriding
     * the default values for the account owner's name by calling the setters for data validation.
     * @param firstName The account owner's first name.
     * @param lastName The account owner's last name.
     */
    public Account(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    /**
     * Allow retrieval of the current account balance.
     * @return The current account balance.
     */
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

    /**
     * Allows making a deposit for amounts greater than zero.
     * @param amount The amount to add to the account balance.
     */
    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException ("Invalid amount [-100.00]. Must be greater than 0.");
        else
            balance += amount;
    }

    /**
     * Allows making a withdrawal for amounts greater than zero and NOT greater than the account balance.
     * @param amount The amount to reduce the account balance.
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount. Must be greater than 0.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Invalid amount. Cannot be greater than the account balance of " + balance);
        }
        balance -= amount;
    }

    /**
     * General account information (id and name) as a string. Example: ID #1: Nassir Binion.
     * @return The account's id and name.
     */
    @Override
    public String toString() {
        return "Account [id#" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
