/**
 * The Food class represents a food item with name and price.
 */
public class Food {
    final private String name;
    private double price;

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
     * Sets the price of food.
     * @param price of the food
     */
    public void setPrice(double price){
        this.price = price;
    }
    /**
     * Returns a string representation of the food.
     * @return a string representation of the food in the format "name is $price."
     */
    public String toString(){
        return name + "is $" + price + ".";
    }
}