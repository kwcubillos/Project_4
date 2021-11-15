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

public class AllOrdersController {

    private MenuController menuController;
    @FXML
    private ComboBox orderBox;
    @FXML
    private TextField orderTotal;
    @FXML
    private ListView list;
    @FXML
    private Button cancelButton;

    protected void setUpScreen(MenuController controller){
        menuController = controller;
        orderBox.setItems(FXCollections.observableArrayList(menuController.orders.getPhoneNumbers()));
        orderBox.getSelectionModel().select(0);
        showPizzas();
    }

    private void showPizzas(){
        Order order = menuController.orders.getOrder(orderBox.getSelectionModel().getSelectedIndex());
        ArrayList<String> pizzas = new ArrayList<>();
        for(Pizza pizza : order.getPizzas()){
            pizzas.add(pizza.toString());
        }
        list.setItems(FXCollections.observableArrayList(pizzas));
        orderTotal.setText("$" + order.getFinalPrice());
    }

    @FXML
    private void showChosenOrder(){
        if(orderBox.getSelectionModel().getSelectedIndex() >= 0){
            showPizzas();
        }
        else{
            ((Stage) cancelButton.getScene().getWindow()).close();
        }
    }

    @FXML
    private void cancelOrder(){
        int index = orderBox.getSelectionModel().getSelectedIndex();
        orderBox.getItems().remove(index);
        menuController.orders.removeOrder(index);
    }

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
