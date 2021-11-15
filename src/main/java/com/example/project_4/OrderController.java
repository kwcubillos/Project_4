package com.example.project_4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pizza_classes.Order;
import pizza_classes.Pizza;

import java.util.ArrayList;

public class OrderController {

    private MenuController menuController;
    @FXML
    private TextField num, subtotal, total, tax;
    @FXML
    private Label numPizza;
    @FXML
    private ListView list;
    @FXML
    private Button placeButton;

    protected void setUpScreen(MenuController controller){
        menuController = controller;
        num.setText(menuController.currentOrder.getPhoneNumber());
        numPizza.setText("Amount of Pizzas: " + menuController.currentOrder.size());
        listPizzas();
        updatePrice();
    }

    private void listPizzas(){
        Order order = menuController.currentOrder;
        ArrayList<String> pizzas = new ArrayList<>();
        for(Pizza pizza : order.getPizzas()){
            pizzas.add(pizza.toString());
        }

        list.setItems(FXCollections.observableArrayList(pizzas));
    }

    private void updatePrice(){
        subtotal.setText("$" + menuController.currentOrder.getSubtotal());
        tax.setText("$" + menuController.currentOrder.getTax());
        total.setText("$" + menuController.currentOrder.getFinalPrice());
    }

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
