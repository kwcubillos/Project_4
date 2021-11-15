package com.example.project_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pizza_classes.Order;
import pizza_classes.StoreOrders;
import java.io.IOException;

/**
 * The JavaFx controller of menuView GUI.
 * The home window that user sees first.
 * @author Kevin Cubillos, Ethan Chang
 */
public class MenuController {

    /** The list of orders to be managed. **/
    private StoreOrders orders = new StoreOrders();
    /** The current order being handled. **/
    private Order currentOrder;
    /** TextField from GUI. **/
    @FXML
    private TextField num;

    /**
     * Sets up the pizza customization screen with a valid customer phone number.
     * @param event Event caused by one of the pizza buttons
     * @throws IOException thrown for any IO errors
     */
    @FXML
    private void setUpPizza(ActionEvent event) throws IOException {
        if(!validNumber()){
            return;
        }
        if(currentOrder == null || !currentOrder.getPhoneNumber().equals(num.getText())){
            currentOrder = new Order(num.getText());
        }
        if(orders.contains(currentOrder.getPhoneNumber())){
            showError("Customer already has an order", "Make sure customer does not have an order yet");
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("customView.fxml"));
        Parent root = loader.load();
        CustomController customView = loader.getController();
        Button selected = ((Button) event.getSource());
        Image chicken = ((ImageView) selected.getGraphic()).getImage();
        customView.setUpScreen(this, selected.getText().toLowerCase(), chicken);
        Stage poop = new Stage();
        poop.setScene(new Scene(root));
        poop.show();
    }

    /**
     * Sets up the order handler screen.
     * @throws IOException thrown for any IO errors
     */
    @FXML
    private void showOrder() throws IOException {
        if(!validNumber()){
            return;
        }
        if(currentOrder == null){
            showError("No Current Order", "Make sure to add pizzas to order first.");
            return;
        }
        if(orders.contains(currentOrder.getPhoneNumber())){
            showError("Customer already has an order", "Make sure customer does not have an order yet");
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("orderView.fxml"));
        Parent root = loader.load();
        OrderController orderView = loader.getController();
        orderView.setUpScreen(this);
        Stage orderScreen = new Stage();
        orderScreen.setScene(new Scene(root));
        orderScreen.show();
    }

    /**
     * Sets up the store orders screen.
     * @throws IOException thrown for any IO errors
     */
    @FXML
    private void showStoreOrders() throws IOException {
        if(orders.getSize() == StoreOrders.EMPTY){
            showError("No Orders", "Make sure there are orders placed.");
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("allOrdersView.fxml"));
        Parent root = loader.load();
        AllOrdersController allOrdersView = loader.getController();
        allOrdersView.setUpScreen(this);
        Stage storeOrdersScreen = new Stage();
        storeOrdersScreen.setScene(new Scene(root));
        storeOrdersScreen.show();
    }

    /**
     * Shows an error on the GUI.
     * @param error Reason for error
     * @param prompt What the user should do
     */
    public void showError(String error, String prompt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(error);
        alert.setHeaderText(prompt);
        alert.showAndWait();
    }

    /**
     * Checks if customer phone number is valid.
     * Needs to be a 10-digit number.
     * @return true if valid, false otherwise
     */
    private boolean validNumber(){
        try{
            if(num == null || num.getText().length() != Order.PHONE_NUMBER_LENGTH){
                showError("Not a number", "Please enter a valid number.");
                return false;
            }
            Long.parseLong(num.getText());

        }catch (Exception e){
            showError("Not a number", "Make sure there are only numbers.");
            return false;
        }
        return true;
    }

    /**
     * Get reference to current order.
     * @return current order
     */
    public Order getCurrentOrder(){
        return currentOrder;
    }

    /**
     * Add an order to the store orders.
     * @param order order to be added
     */
    public void addToOrders(Order order){
        orders.addOrder(order);
        currentOrder = null;
        num.setText("");
    }

    /**
     * Get reference to store orders.
     * @return store orders
     */
    public StoreOrders getStoreOrders(){
        return orders;
    }

}
