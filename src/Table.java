/**
 * The class represents a Table in a Restaurant
 * It includes the table number, table capacity, and the customer assigned to the table
 */
public class Table {
    private final int number;
    private final int capacity;
    private Customer customer;

    /**
     * Constructs new Table
     * @param number the table number
     * @param capacity the capacity of the table
     */
    public Table(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    /**
     * Assigns a customer to the table
     * If the customer is already seated or the table is reserved, a message is displayed to convey this message
     * If the customer's party size exceeds the table's capacity, a message is displayed to convey this message
     * @param customer the customer to be assigned to the table
     */
    public void assignCustomer(Customer customer) {
        if (customer.getNumber() != 0) {
            System.out.println("Customer is already seated.");
        } else if (!(this.customer == null)) {
            System.out.println("Table is already reserved.");
        } else if (customer.getParty() > capacity) {
                System.out.println("Table cannot fit party.");
        } else {
            System.out.println(customer.getName() + "'s party successfully assigned to Table " + number);
            this.customer = customer;
            customer.setNumber(number);
        }
    }

    /**
     * Removes the customer from the table
     * If the table is empty, a String is printed to convey this message
     */
    public void removeCustomer() {
        if (customer != null) {
            System.out.println(customer.getName() + "'s party successfully removed from Table " + number);
            customer = null;
        } else {
            System.out.println("Table is empty.");
        }
    }

    /**
     * Gets customer assigned to the table
     * If the table is empty, an appropriate message is printed and null is returned
     * @return the customer assigned to the table, or null if the table is empty.
     */
    private Customer getCustomer() {
        if (customer != null) {
            return customer;
        } else {
            System.out.println("Table is empty.");
            return null;
        }
    }

    /**
     * Displays a string representation of the table
     * Includes the table number, the customer, seated. and the table's capacity.
     * @return A string describing the table
     */
    public String toString() {
        if (customer != null) {
            return "Table " + number + "\nSeated: " + getCustomer().getName() + ", party of " + getCustomer().getParty() + "\nCapacity: " + capacity + " people";
        } else {
            return "Table " + number + "\nEmpty\nCapacity: " + capacity + " people";
        }
    }
}
