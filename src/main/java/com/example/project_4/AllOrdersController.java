package com.example.project_4;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pizza_classes.Order;
import pizza_classes.Pizza;
import java.io.File;
import java.util.ArrayList;

/**
 * The JavaFX controller of allOrdersView GUI.
 * Helps set up and manage the orders placed.
 * @author Kevin Cubillos, Ethan Chang
 */
public class AllOrdersController {

    /** Index of first order for set up. **/
    private static final int FIRST_ORDER = 0;
    /** The reference to the menu controller to access orders. **/
    private MenuController menuController;
    /** ComboBox from GUI. **/
    @FXML
    private ComboBox orderBox;
    /** TextField from GUI. **/
    @FXML
    private TextField orderTotal;
    /** ListView from GUI. **/
    @FXML
    private ListView list;
    /** Button box from GUI. **/
    @FXML
    private Button cancelButton;

    /**
     * Sets up the initial screen.
     * @param controller the MenuController to store its reference
     */
    protected void setUpScreen(MenuController controller){
        menuController = controller;
        orderBox.setItems(FXCollections.observableArrayList(menuController.orders.getPhoneNumbers()));
        orderBox.getSelectionModel().select(FIRST_ORDER);
        showPizzas();
    }

    /**
     * Populates the ListView with all pizzas from selected order.
     */
    private void showPizzas(){
        Order order = menuController.orders.getOrder(orderBox.getSelectionModel().getSelectedIndex());
        ArrayList<String> pizzas = new ArrayList<>();
        for(Pizza pizza : order.getPizzas()){
            pizzas.add(pizza.toString());
        }
        list.setItems(FXCollections.observableArrayList(pizzas));
        orderTotal.setText("$" + order.getFinalPrice());
    }

    /**
     * Updates information on screen based on new selected order.
     * The window is closed when all orders have been cancelled.
     */
    @FXML
    private void showChosenOrder(){
        if(orderBox.getSelectionModel().getSelectedIndex() >= FIRST_ORDER){
            showPizzas();
        }
        else{
            ((Stage) cancelButton.getScene().getWindow()).close();
        }
    }

    /**
     * Cancels an order and removes it from the list of orders.
     */
    @FXML
    private void cancelOrder(){
        int index = orderBox.getSelectionModel().getSelectedIndex();
        orderBox.getItems().remove(index);
        menuController.orders.removeOrder(index);
    }

    /**
     * Lets the user choose a file to export data of all orders.
     */
    @FXML
    private void exportOrders(){
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Choose location of export file");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File targetFile = chooser.showSaveDialog(stage);
        menuController.orders.export(targetFile);
    }


}
