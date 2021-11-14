package pizza_classes;

/**
 *
 * @author Ethan Chang and Kevin Cubillos
 */
public class HawaiianPizza extends Pizza {

    private static final int HAWAIIAN_TOPPING_COUNT = 2;
    private static final double HAWAIIAN_INIT_PRICE = 10.99;

    /**
     * Constructor for HawaiianPizza
     */
    public HawaiianPizza() {
        toppings.add(Topping.HAM);
        toppings.add(Topping.PINEAPPLE);
        size = Size.SMALL;
    }

    /**
     * Returns the number of toppings for this pizza
     *
     * @return the number of toppings for this pizza
     */
    public double price(){
        double price = HAWAIIAN_INIT_PRICE;
        int extraToppings = toppings.size() - HAWAIIAN_TOPPING_COUNT;
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

    @Override
    public String toString(){
        return "Hawaiian " + super.toString();
    }
}
