package pizza_classes;

/**
 *
 * @author Ethan Chang and Kevin Cubillos
 */
public class HawaiianPizza extends Pizza {

    private static final int HAWAIIAN_TOPPING_COUNT = 2;

    /**
     * Constructor for HawaiianPizza
     */
    public HawaiianPizza() {
        price = 10.99;
        toppings.add(Topping.HAM);
        toppings.add(Topping.PINEAPPLE);
    }

    /**
     * Returns the number of toppings for this pizza
     *
     * @return the number of toppings for this pizza
     */
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
        if (toppings.size() == HAWAIIAN_TOPPING_COUNT) {
            price -= ADD_TOPPING_PRICE;
        }
    }
}
