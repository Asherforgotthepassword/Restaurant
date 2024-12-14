public class Customer {
    private final String name;
    private final int party;
    private Food order = new Food();

    public Customer(String name, int party) {
        this.name = name;
        this.party = party;
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
}
