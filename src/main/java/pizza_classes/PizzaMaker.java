package pizza_classes;

/**
 * Class that handles instantiation of correct pizza flavor.
 * @author Kevin Cubillos, Ethan Chang
 */
public class PizzaMaker {

    /**
     * Creates an instance of the correct pizza flavor
     * @param flavor Flavor of pizza
     * @return the instance of pizza flavor
     */
    public static Pizza createPizza(String flavor) {
        Pizza pizza = switch (flavor) {
            case "deluxe" -> new DeluxePizza();
            case "hawaiian" -> new HawaiianPizza();
            case "pepperoni" -> new PepperoniPizza();
            default -> null;
        };
        return pizza;
    }
}
