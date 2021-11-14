package com.example.project_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pizza_classes.Order;
import pizza_classes.StoreOrders;

import java.io.IOException;

public class MenuController {

    protected StoreOrders orders = new StoreOrders();
    protected Order currentOrder;
    @FXML
    protected TextField num;

    @FXML
    private void setUpPizza(ActionEvent event) throws IOException {
        if(!validNumber()){
            return;
        }
        currentOrder = orders.findOrder(num.getText());
        if(currentOrder == null){
            currentOrder = new Order(num.getText());
            orders.addOrder(currentOrder);
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("customView.fxml"));
        Parent root = (Parent) loader.load();
        CustomController customView = loader.getController();
        Button selected = ((Button) event.getSource());
        Image chicken = ((ImageView) selected.getGraphic()).getImage();
        customView.setUpScreen(this, selected.getText().toLowerCase(), chicken);
        Stage poop = new Stage();
        poop.setScene(new Scene(root));
        poop.show();
    }

    @FXML
    private void showOrder() throws IOException {
        if(!validNumber()){
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("orderView.fxml"));
        Parent root = (Parent) loader.load();
        OrderController orderView = loader.getController();
        orderView.setUpScreen(this);
        Stage orderScreen = new Stage();
        orderScreen.setScene(new Scene(root));
        orderScreen.show();
    }

    public void showError(String error, String prompt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(error);
        alert.setHeaderText(prompt);
        alert.showAndWait();
    }

    private boolean validNumber(){
        try{
            System.out.println(num.getText().length());
            if(num == null || num.getText().length() != 10){
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


}
