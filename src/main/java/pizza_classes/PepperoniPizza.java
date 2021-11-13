package pizza_classes;

public class PepperoniPizza extends Pizza {

    private static final int PEPPERONI_TOPPING_COUNT = 1;

    public PepperoniPizza() {
        price = 8.99;
        toppings.add(Topping.PEPPERONI);
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
        if (toppings.size() == PEPPERONI_TOPPING_COUNT) {
            price -= ADD_TOPPING_PRICE;
        }
    }
}
