package pizza_classes;

import java.util.ArrayList;

public abstract class Pizza {
    private enum Topping{

    }

    private enum Size{
        small,
        medium,
        large
    }
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;
}
