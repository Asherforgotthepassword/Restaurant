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
    public void removeCustomer() {
        if (customer != null) {
            System.out.println(customer.getName() + "'s party successfully removed from Table " + number);
            customer = null;
        } else {
            System.out.println("Table is empty.");
        }
    }
    private Customer getCustomer() {
        if (customer != null) {
            return customer;
        } else {
            System.out.println("Table is empty.");
            return null;
        }
    }
    public String toString() {
        if (customer != null) {
            return "Table " + number + "\nSeated: " + getCustomer().getName() + ", party of " + getCustomer().getParty() + "\nCapacity: " + capacity + " people";
        } else {
            return "Table " + number + "\nEmpty\nCapacity: " + capacity + " people";
        }
    }
}
