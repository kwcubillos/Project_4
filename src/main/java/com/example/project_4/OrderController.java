package com.example.project_4;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pizza_classes.Order;
import pizza_classes.Pizza;
import java.util.ArrayList;

/**
 * The JavaFx controller of orderView GUI.
 * Manages the current order being processed.
 * @author Kevin Cubillos, Ethan Chang
 */
public class OrderController {

    /** The reference to the menu controller to access current order **/
    private MenuController menuController;
    /** Current order **/
    private Order currentOrder;
    /** TextFields from GUI **/
    @FXML
    private TextField num, subtotal, total, tax;
    /** Label from GUI **/
    @FXML
    private Label numPizza;
    /** ListView from GUI **/
    @FXML
    private ListView list;
    /** Button from GUI **/
    @FXML
    private Button placeButton;

    /**
     * Sets up the screen with data of current order.
     * @param controller MenuController reference
     */
    protected void setUpScreen(MenuController controller){
        menuController = controller;
        currentOrder = menuController.getCurrentOrder();
        num.setText(currentOrder.getPhoneNumber());
        numPizza.setText("Amount of Pizzas: " + currentOrder.size());
        listPizzas();
        updatePrice();
    }

    /**
     * Populates the ListView with pizza information.
     */
    private void listPizzas(){
        ArrayList<String> pizzas = new ArrayList<>();
        for(Pizza pizza : currentOrder.getPizzas()){
            pizzas.add(pizza.toString());
        }

        list.setItems(FXCollections.observableArrayList(pizzas));
    }

    /**
     * Updates the price of current order.
     */
    private void updatePrice(){
        subtotal.setText("$" + currentOrder.getSubtotal());
        tax.setText("$" + currentOrder.getTax());
        total.setText("$" + currentOrder.getFinalPrice());
    }

    /**
     * Removes the selected pizza from order and updates GUI.
     */
    @FXML
    private void removeSelectedPizza(){
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        list.getItems().remove(selectedIndex);
        currentOrder.removePizza(selectedIndex);
        numPizza.setText("Amount of Pizzas: " + currentOrder.size());
        updatePrice();
        if(list.getSelectionModel().getSelectedIndex() == -1){
            ((Stage) placeButton.getScene().getWindow()).close();
            currentOrder = null;
        }
    }

    /**
     * Adds the order to the store orders and closes the window.
     */
    @FXML
    private void placeOrder(){
        if(currentOrder.getPizzas().size() == Order.EMPTY){
            menuController.showError("There are no pizzas", "Add pizzas to place an order.");
            return;
        }
        menuController.addToOrders(currentOrder);
        ((Stage) placeButton.getScene().getWindow()).close();
    }
}
