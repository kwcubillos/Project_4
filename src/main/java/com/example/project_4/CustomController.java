package com.example.project_4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pizza_classes.*;
import java.util.ArrayList;

/**
 * The JavaFx controller of customView GUI.
 * Manages the customization of a pizza.
 * @author Kevin Cubillos, Ethan Chang
 */
public class CustomController{
    /** The required toppings of the given pizza. **/
    private ArrayList<Topping> requireToppings  = new ArrayList<>();
    /** The pizza that is current being made. **/
    private Pizza currentPizza;
    /** The reference to the menu controller to access current order. **/
    private MenuController menuController;
    /** ListViews from the GUI. **/
    @FXML
    private ListView notAddedList, addedList;
    /** ComboBox from the GUI. **/
    @FXML
    private ComboBox sizes;
    /** ImageView from the GUI. **/
    @FXML
    private ImageView pizzaImg;
    /** TextField from the GUI. **/
    @FXML
    private TextField price;
    /** Button from the GUI. **/
    @FXML
    private Button orderButton;

    /**
     * Sets up the initial screen.
     */
    @FXML
    private void initialize(){
        ObservableList<Size> size = FXCollections.observableArrayList(Size.values());
        sizes.setItems(size);
        sizes.getSelectionModel().select(Size.SMALL);
        price.setText("0.00");
        ObservableList<Topping> toppings = FXCollections.observableArrayList(Topping.values());
        notAddedList.setItems(toppings);
    }

    /**
     * Updates screen to the specific pizza.
     * Image and toppings are updated to corresponding pizza.
     * @param controller MenuController reference
     * @param flavor the type of pizza flavor
     * @param img the image of pizza flavor
     */
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

    /**
     * Adds a topping to the pizza and updates price and GUI.
     * Shows error if max toppings amount has been reached.
     */
    @FXML
    private void addTopping(){
        Topping juice = (Topping) notAddedList.getSelectionModel().getSelectedItem();
        if(juice == null){
            return;
        }
        if(currentPizza.addTopping(juice)){
            notAddedList.getItems().remove(juice);
            addedList.getItems().add(juice);
            price.setText(currentPizza.priceFormatted());
        }
        else{
            menuController.showError("Max Toppings Reached", "Remove a topping to add another");
        }


    }

    /**
     * Removes a topping from the pizza and updates GUI.
     * Error is shown when a required topping is attempted to be removed.
     */
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

    /**
     * Updates the size of the pizza and updates GUI.
     */
    @FXML
    private void updateSize(){
        Size newSize = (Size) sizes.getSelectionModel().getSelectedItem();
        currentPizza.setSize(newSize);
        price.setText(currentPizza.priceFormatted());
    }

    /**
     * Adds the pizza to the current order and closes the window.
     */
    @FXML
    private void addToOrder(){
        menuController.currentOrder.addPizza(currentPizza);
        Stage stage = (Stage) orderButton.getScene().getWindow();
        stage.close();
    }
}
