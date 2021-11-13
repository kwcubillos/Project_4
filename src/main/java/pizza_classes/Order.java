package pizza_classes;

import java.util.ArrayList;

/**
 * This class represents an order.
 * @author Ethan Chang and Kevin Cubillos
 */
public class Order {
    private static final double SALES_TAX = 0.6625;
    private static final double EMPTY_ORDER_TOTAL = 0.00;
    private int phoneNumber;
    private ArrayList<Pizza> pizzas;
    private double currentPrice;

    /**
     * Constructor for Order.
     * @param phoneNumber The phone number of the customer.
     */
    public Order(int phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.pizzas = new ArrayList<>();
        this.currentPrice = EMPTY_ORDER_TOTAL;
    }

    /**
     * Gets the phone number of the customer.
     * @return The phone number of the customer.
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets the pizzas in the order.
     * @return The pizzas in the order.
     */
    @Override
    public String toString() {
        return "Order{" +
                "phoneNumber=" + phoneNumber +
                ", pizzas=" + pizzas +
                '}';
    }

    /**
     * Adds a pizza to the order.
     * @param pizza The pizza to add.
     */
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    /**
     * remove a pizza from the order.
     * @param pizza The pizza to remove.
     */
    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    /**
     * Calculates the subtotal of the order.
     */
    public void calculateSubtotal() {
        double price = EMPTY_ORDER_TOTAL;
        for (Pizza pizza : pizzas) {
            price += pizza.price();
        }
        this.currentPrice = price;
    }

    /**
     * Calculates the total of the order with tax.
     * @return The total of the order with tax applied.
     */
    public double getFinalPrice() {
        return currentPrice *= SALES_TAX;
    }
}
