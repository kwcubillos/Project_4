package pizza_classes;

/**
 * This enum represents the different toppings that can be added to a pizza.
 * @author Ethan Chang and Kevin Cubillos
 */
public enum Topping {
    SAUSAGE("Sausage"), HAM("Ham"), MUSHROOM("Mushroom"), ONION("Onion"), 
        PEPPERONI("Pepperoni"), PINEAPPLE("Pineapple"), BACON("Bacon");

        private String topping;
        
        private Topping(String topping){
            this.topping = topping;
        }

        public String getTopping(){
            return topping;
        }
}
