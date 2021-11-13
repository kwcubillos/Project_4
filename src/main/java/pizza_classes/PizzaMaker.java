package pizza_classes;

public class PizzaMaker {
    public static Pizza createPizza(String flavor) {
        Pizza pizza = null;
        if (flavor.equals("deluxe")) {
            pizza = new DeluxePizza();
        } else if (flavor.equals("hawaiian")) {
            pizza = new HawaiianPizza();
        } else if (flavor.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }
        return pizza;
    }
}
