package pizza_classes;

public class PepperoniPizza extends Pizza {

    private static final int PEPPERONI_TOPPING_COUNT = 1;
    private static final double PEPPERONI_INIT_PRICE = 8.99;

    public PepperoniPizza() {
        toppings.add(Topping.PEPPERONI);
        size = Size.SMALL;
    }

    public double price(){
        double price = PEPPERONI_INIT_PRICE;
        int extraToppings = toppings.size() - PEPPERONI_TOPPING_COUNT;
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
        return "Pepperoni " + super.toString();
    }
}
