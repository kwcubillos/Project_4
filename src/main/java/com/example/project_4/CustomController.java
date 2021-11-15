package com.example.project_4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pizza_classes.*;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class CustomController{
    private ArrayList<Topping> requireToppings  = new ArrayList<>();
    private Pizza currentPizza;
    private MenuController menuController;
    @FXML
    private ListView notAddedList, addedList;
    @FXML
    private ComboBox sizes;
    @FXML
    private ImageView pizzaImg;
    @FXML
    private TextField price;
    @FXML
    private Button orderButton;

    @FXML
    private void initialize(){

        ObservableList<Size> size = FXCollections.observableArrayList(Size.values());
        sizes.setItems(size);
        sizes.getSelectionModel().select(Size.SMALL);
        price.setText("0.00");
        ObservableList<Topping> toppings = FXCollections.observableArrayList(Topping.values());
        notAddedList.setItems(toppings);
    }

    protected void setUpScreen(MenuController controller, String flavor, Image img){
        menuController = controller;
        ArrayList<Topping> toppings;
        currentPizza = PizzaMaker.createPizza(flavor);
        toppings = currentPizza.getToppings();
        requireToppings.addAll(toppings);
        addedList.getItems().addAll(toppings);
        notAddedList.getItems().removeAll(toppings);
        pizzaImg.setImage(img);
        price.setText(currentPizza.priceFormatted());
    }

    @FXML
    private void addTopping(){
        Topping juice = (Topping) notAddedList.getSelectionModel().getSelectedItem();
        if(juice == null){
            return;
        }
        currentPizza.addTopping(juice);
        notAddedList.getItems().remove(juice);
        addedList.getItems().add(juice);
        price.setText(currentPizza.priceFormatted());
    }

    @FXML
    private void removeTopping(){
        Topping juice = (Topping) addedList.getSelectionModel().getSelectedItem();
        if(juice == null || requireToppings.contains(juice)){
            menuController.showError("Cannot remove default toppings", "Remove only additional toppings");
            return;
        }
        currentPizza.removeTopping(juice);
        addedList.getItems().remove(juice);
        notAddedList.getItems().add(juice);
        price.setText(currentPizza.priceFormatted());
    }

    @FXML
    private void updateSize(){
        Size newSize = (Size) sizes.getSelectionModel().getSelectedItem();
        currentPizza.setSize(newSize);
        price.setText(currentPizza.priceFormatted());
    }

    @FXML
    private void addToOrder(){
        menuController.currentOrder.addPizza(currentPizza);
        Stage stage = (Stage) orderButton.getScene().getWindow();
        stage.close();
    }
}
