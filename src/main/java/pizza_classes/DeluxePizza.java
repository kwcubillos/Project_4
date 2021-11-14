package pizza_classes;

public class DeluxePizza extends Pizza {

    private static final int DELUXE_TOPPING_COUNT = 5;
    private static final double DELUXE_INIT_PRICE = 12.99;

    public DeluxePizza() {
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.ONION);
        toppings.add(Topping.MUSHROOM);
        toppings.add(Topping.BACON);
        toppings.add(Topping.HAM);
        size = Size.SMALL;
    }

    public double price(){
        double price = DELUXE_INIT_PRICE;
        int extraToppings = toppings.size() - DELUXE_TOPPING_COUNT;
        if(extraToppings > 0){
            price += extraToppings * ADD_TOPPING_PRICE;
        }
        switch(size){
            case SMALL:
                break;
            case MEDIUM:
                price += SIZE_INCREASE_UPCHARGE;
                break;
            case LARGE:
                price += SIZE_INCREASE_UPCHARGE + SIZE_INCREASE_UPCHARGE;
                break;
        }
        return price;
    }

    /**
     * Removes a topping from this pizza and deducts the price if possible
     * 
     * @param topping the topping to remove
     */
    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    @Override
    public String toString(){
        return "Deluxe " + super.toString();
    }
}
