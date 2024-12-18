/**
 * This class is a representation of a Customer.
 * It includes the customer's name, party size, order, and order number.
 */
public class Customer {
    private final String name;
    private final int party;
    private Food order;
    private int number;

    /**
     * Constructs a new Customer
     * @param name The name of the Customer
     * @param party The size of party
     */
    public Customer(String name, int party) {
        this.name = name;
        this.party = party;
        number = 0;
    }

    /**
     * Gets name of the customer
     * @return name the name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     * Gets size of the party
     * @return The size of the party
     */
    public int getParty() {
        return party;
    }

    /**
     * Gets the customer's order
     * If order is null, the empty order is printed and null is retuned
     * @return order, the customer's order, or null if no order is placed
     */
    public Food getOrder() {
        if (order == null) {
            System.out.println("Order is empty.");
            return null;
        } else {
            return order;
        }
    }

    /**
     * Adds an order to the customer
     * @param food the food item that will be added to the order
     */
    public void setOrder(Food food) {
        order = food;
    }

    /**
     * Gets the order number of the customer
     * @return number the order number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets order number of the customer
     * @param number the new table number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * String representation of the customer
     * Includes the name, party size, and table number if seated
     * @return A string representation describing the customer
     */
    public String toString() {
        if (number != 0) {
            return "Customer: " + name + "\nParty: " + party + "\nTable: " + number;
        }
        return "Customer: " + name + "\nParty: " + party + "\nNot Seated";
    }
}
