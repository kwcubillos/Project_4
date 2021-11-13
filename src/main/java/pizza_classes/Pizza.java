package pizza_classes;

import java.util.ArrayList;

/**
 * This class represents a Pizza.
 * @author Ethan Chang, Kevin Cubillos;
 */
public abstract class Pizza {

    private static final double SIZE_INCREASE_UPCHARGE = 2.00;
    protected static final double ADD_TOPPING_PRICE = 1.49;
    private static final int MAX_TOPPINGS = 7;
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;
    protected double price;

    public abstract double price();

    /**
     * Adds a topping to the pizza.
     * @param topping The topping to be added.
     * @return True if topping was added, false if topping was not added.
     */
    public boolean addTopping(Topping topping){
        if(toppings.size() < MAX_TOPPINGS){
            toppings.add(topping);
            price += ADD_TOPPING_PRICE;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Removes a topping from this pizza
     * 
     * @param topping the topping to remove
     */
    public void removeTopping(Topping topping){
        toppings.remove(topping);
    }

    /**
     * Upgrades the size of this pizza
     *
     * @param size the current size of this pizza
     * @return true if possible, false otherwise
     */
    public boolean upgradeSize(Size size){
        switch(size){
            case SMALL:
                this.size = Size.MEDIUM;
                this.price += SIZE_INCREASE_UPCHARGE;
                return true;
            case MEDIUM:
                this.size = Size.LARGE;
                this.price += SIZE_INCREASE_UPCHARGE;
                return true;
            case LARGE:
                return false;
        }
        return false;
    }

    /**
     * Downgrades the size of this pizza
     *
     * @param size the current size of this pizza
     * @return true if possible, false otherwise
     */
    public boolean downgradeSize(Size size){
        switch(size){
            case SMALL:
                return false;
            case MEDIUM:
                this.size = Size.SMALL;
                this.price -= SIZE_INCREASE_UPCHARGE;
                return true;
            case LARGE:
                this.size = Size.MEDIUM;
                this.price -= SIZE_INCREASE_UPCHARGE;
                return true;
        }
        return false;
    }
}
