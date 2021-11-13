package pizza_classes;

/**
 * This enum represents the different sizes of pizza.
 * @author Ethan Chang and Kevin Cubillos
 */
public enum Size {
    SMALL("Small"), MEDIUM("Medium"), LARGE("Large");

        private String pizzaSize;

        private Size(String pizzaSize){
            this.pizzaSize = pizzaSize;
        }

        public String getPizzaSize(){
            return pizzaSize;
        }
}
