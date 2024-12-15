/**
 * The Food class represents a food item with name and price.
 */
public class Food {
    private String name;
    private int price;

    /**
     * Constructs a new Food object with given name and price.
     * @param name the name of food
     * @param price the price of food
     */
    public Food(String name, int price)
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
     * Sets the name of food.
     * @param name of the food
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Sets the price of food.
     * @return price the price of food
     */
    public int getPrice(){
        return price;
    }

    /**
     * Sets the price of food.
     * @param price of the food
     */
    public void setPrice(int price){
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