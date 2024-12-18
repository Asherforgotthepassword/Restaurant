/**
 * The Food class represents a food item
 * It includes a name and price.
 */
public class Food {
    final private String name;
    private final double price;

    /**
     * Constructs a new Food object with given name and price.
     * @param name the name of food
     * @param price the price of food
     */
    public Food(String name, double price)
    {
        this.name = name;
        this.price = price;
    }
    /**
     * Gets name of food.
     * return name the name of food
     */
    public String getName(){
        return name;
    }
    /**
     * Sets the price of food.
     * @return price the price of food
     */
    public double getPrice(){
        return price;
    }
    /**
     * Returns a string representation of the food.
     * @return a string representation of the food in the format "name is $price."
     */
    public String toString(){
        return name + "is $" + price + ".";
    }
}