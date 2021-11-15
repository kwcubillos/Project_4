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
        num.setText(menuController.currentOrder.getPhoneNumber());
        numPizza.setText("Amount of Pizzas: " + menuController.currentOrder.size());
        listPizzas();
        updatePrice();
    }

    /**
     * Populates the ListView with pizza information.
     */
    private void listPizzas(){
        Order order = menuController.currentOrder;
        ArrayList<String> pizzas = new ArrayList<>();
        for(Pizza pizza : order.getPizzas()){
            pizzas.add(pizza.toString());
        }

        list.setItems(FXCollections.observableArrayList(pizzas));
    }

    /**
     * Updates the price of current order.
     */
    private void updatePrice(){
        subtotal.setText("$" + menuController.currentOrder.getSubtotal());
        tax.setText("$" + menuController.currentOrder.getTax());
        total.setText("$" + menuController.currentOrder.getFinalPrice());
    }

    /**
     * Removes the selected pizza from order and updates GUI.
     */
    @FXML
    private void removeSelectedPizza(){
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        list.getItems().remove(selectedIndex);
        menuController.currentOrder.removePizza(selectedIndex);
        numPizza.setText("Amount of Pizzas: " + menuController.currentOrder.size());
        updatePrice();
        if(list.getSelectionModel().getSelectedIndex() == -1){
            ((Stage) placeButton.getScene().getWindow()).close();
            menuController.currentOrder = null;
            menuController.num.setText("");
        }
    }

    /**
     * Adds the order to the store orders and closes the window.
     */
    @FXML
    private void placeOrder(){
        if(menuController.currentOrder.getPizzas().size() == 0){
            menuController.showError("There are no pizzas", "Add pizzas to place an order.");
            return;
        }
        menuController.orders.addOrder(menuController.currentOrder);
        menuController.currentOrder = null;
        menuController.num.setText("");
        ((Stage) placeButton.getScene().getWindow()).close();
    }
}
