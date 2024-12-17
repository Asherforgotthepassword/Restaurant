public class Customer {
    private final String name;
    private final int party;
    private Food order;
    private int number;

    public Customer(String name, int party) {
        this.name = name;
        this.party = party;
        number = 0;
    }
    public String getName() {
        return name;
    }
    public int getParty() {
        return party;
    }
    public Food getOrder() {
        if (order == null) {
            System.out.println("Order is empty.");
            return null;
        } else {
            return order;
        }
    }
    public void addOrder(Food food) {
        order = food;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String toString() {
        if (number != 0) {
            return "Customer: " + name + "\nParty: " + party + "\nTable: " + number;
        }
        return "Customer: " + name + "\nParty: " + party + "\nNot Seated";
    }
}
