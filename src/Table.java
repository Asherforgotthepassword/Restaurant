public class Table {
    private final int number;
    private final int capacity;
    private Customer customer;
    public Table(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
    }
    public int getNumber() {
        return number;
    }
    public void assignCustomer(Customer customer) {
        if (this.customer == null) {
            if (customer.getParty() > capacity) {
                System.out.println("Table cannot fit party.");
            } else {
                System.out.println(customer.getName() + "'s party successfully assigned to Table " + number);
                this.customer = customer;
            }
        } else {
            System.out.println("Table is already reserved.");
        }
    }
    public void removeCustomer() {
        if (customer != null) {
            System.out.println(customer.getName() + "'s party successfully removed from Table " + number);
            customer = null;
        } else {
            System.out.println("Table is empty.");
        }
    }
    public Customer getCustomer() {
        if (customer != null) {
            return customer;
        } else {
            System.out.println("Table is empty.");
            return null;
        }
    }
    public String toString() {
        if (customer != null) {
            return "Table " + number + " is currently seating " + getCustomer().getName() + "'s party of " + getCustomer().getParty() + " and can hold up to " + capacity + " people.";
        } else {
            return "Table " + number + " is currently empty and can hold up to " + capacity + " people.";
        }
    }
}
