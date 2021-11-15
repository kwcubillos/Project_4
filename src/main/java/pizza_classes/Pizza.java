package pizza_classes;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class represents a Pizza.
 * @author Ethan Chang, Kevin Cubillos;
 */
public abstract class Pizza {


    protected static final double SIZE_INCREASE_UPCHARGE = 2.00;
    protected static final double ADD_TOPPING_PRICE = 1.49;
    private static final int MAX_TOPPINGS = 7;
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;

    public abstract double price();

    /**
     * Adds a topping to the pizza.
     *
     * @param topping The topping to be added.
     * @return True if topping was added, false if topping was not added.
     */
    public boolean addTopping(Topping topping){
        if(toppings.size() < MAX_TOPPINGS){
            toppings.add(topping);
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
     * Changes the size of the pizza.
     * @param size The new size of the pizza.
     */
    public void setSize(Size size){
        this.size = size;
    }

    /**
     *This builds a string representation of the pizza with the toppings
     *
     * @return a string representation of the pizza
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza: ");
        sb.append(size.toString() + ", ");
        for(int i = 0; i < toppings.size(); i++){
            sb.append(toppings.get(i) + ", ");
        }
        sb.append("Cost: $" + priceFormatted());
        return sb.toString();
    }
    
    public ArrayList<Topping> getToppings(){
        return toppings;
    }

    public String priceFormatted(){
        return Order.DECIMAL_FORMAT.format(price());
    }

}
