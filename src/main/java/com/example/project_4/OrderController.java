package com.example.project_4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pizza_classes.Order;
import pizza_classes.Pizza;
import pizza_classes.StoreOrders;

import java.util.ArrayList;

public class OrderController {

    private MenuController menuController;
    @FXML
    private TextField num, subtotal, total, tax;
    @FXML
    private ListView list;

    protected void setUpScreen(MenuController controller){
        menuController = controller;
        num.setText(menuController.num.getText());
        listPizzas();

    }

    private void listPizzas(){
        Order order = menuController.currentOrder;
        ArrayList<String> pizzas = new ArrayList<>();
        for(Pizza pizza : order.getPizzas()){
            System.out.println(pizza.toString());
            pizzas.add(pizza.toString());
        }

        list.setItems(FXCollections.observableArrayList(pizzas));
    }
}
