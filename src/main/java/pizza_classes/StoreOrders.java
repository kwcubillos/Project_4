package pizza_classes;

import java.io.*;
import java.util.ArrayList;

/**
 * This class holds all the orders that have been placed.
 * @author Ethan Chang and Kevin Cubillos
 */
public class StoreOrders {
    private ArrayList<Order> orders;

    /**
     * Constructor for the StoreOrders class.
     */
    public StoreOrders() {
        orders = new ArrayList<>();
    }

    /**
     * Adds an order to the list of orders.
     * @param order The order to be added.
     */
    public void addOrder(Order order) {
        orders.add(order);
    }

    /**
     * This method removes an order from the list of orders.
     * @param index The order to be removed.
     */
    public void removeOrder(int index) {
        orders.remove(index);
    }

    /**
    * This method returns the ArrayList of orders.
    * @return the ArrayList of orders.
    */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
    * This method returns all the orders to a string separated by new lines.
    * @return String with all the orders separated by new lines.
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Order order : orders) {
            sb.append(order.toString() + "\n");
        }
        return sb.toString();
    }

    /**
     * This method saves the orders to a file.
     *
     */
    public void export(File file) {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Order order : orders) {
                bw.write(order.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean contains(String num){
        for(int i = 0; i < orders.size(); i++){
            if(num.equals(orders.get(i).getPhoneNumber())){
                return true;
            }
        }

        return false;
    }

    public Order getOrder(int index){
        return orders.get(index);
    }

    public ArrayList<String> getPhoneNumbers(){
        ArrayList<String> numbers = new ArrayList<>();
        for(int i = 0; i < orders.size(); i++){
            numbers.add(orders.get(i).getPhoneNumber());
        }
        return numbers;
    }

    public int getSize(){
        return orders.size();
    }
}
