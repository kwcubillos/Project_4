package pizza_classes;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class represents an order.
 * @author Ethan Chang and Kevin Cubillos
 */
public class Order {
    private static final String FORMAT = "##,##0.00";
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(FORMAT);
    private static final double SALES_TAX = 0.06625;
    private static final double EMPTY_ORDER_TOTAL = 0.00;
    private String phoneNumber;
    private ArrayList<Pizza> pizzas;
    private double currentPrice;

    /**
     * Constructor for Order.
     * @param phoneNumber The phone number of the customer.
     */
    public Order(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.pizzas = new ArrayList<>();
        this.currentPrice = EMPTY_ORDER_TOTAL;
    }

    /**
     * Gets the phone number of the customer.
     * @return The phone number of the customer.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets the pizzas in the order.
     * @return The pizzas in the order.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Phone Number: " + phoneNumber);
        for (Pizza pizza : pizzas) {
            sb.append("; " + pizza.toString());
        }
        sb.append("; " + "Total: " + getFinalPrice());
        return sb.toString();
    }

    /**
     * Adds a pizza to the order.
     * @param pizza The pizza to add.
     */
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
        currentPrice += pizza.price();
    }

    /**
     * remove a pizza from the order.
     * @param i The pizza to remove.
     */
    public void removePizza(int i) {
        Pizza removed = pizzas.remove(i);
        currentPrice -= removed.price();
        if(currentPrice < 0){
            currentPrice = 0;
        }
    }

    /**
     * Calculates the total of the order with tax.
     * @return The total of the order with tax applied.
     */
    public String getFinalPrice() {
        return DECIMAL_FORMAT.format(currentPrice + currentPrice * SALES_TAX);
    }

    public String getSubtotal(){
        return DECIMAL_FORMAT.format(currentPrice);
    }

    public String getTax(){
        return DECIMAL_FORMAT.format(currentPrice * SALES_TAX);
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }
}
