package pizza_classes;

public class DeluxePizza extends Pizza {

    private static final int DELUXE_TOPPING_COUNT = 5;

    public DeluxePizza() {
        price = 12.99;
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.ONION);
        toppings.add(Topping.MUSHROOM);
        toppings.add(Topping.BACON);
        toppings.add(Topping.HAM);
        size = Size.SMALL;
    }

    public double price(){
        return price;
    }

    /**
     * Removes a topping from this pizza and deducts the price if possible
     * 
     * @param topping the topping to remove
     */
    public void removeTopping(Topping topping) {
        toppings.remove(topping);
        if (toppings.size() == DELUXE_TOPPING_COUNT) {
            price -= ADD_TOPPING_PRICE;
        }
    }
}
