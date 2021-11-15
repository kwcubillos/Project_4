package com.example.project_4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Main driver that launches the application.
 * @author Kevin Cubillos, Ethan Chang
 */
public class Main extends Application {
    /**
     * Sets up the main window of Pizza App.
     * @param stage Menu window shown when application starts
     * @throws IOException thrown for any IO error
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menuView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Juicey Pizza Shop");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launches the application.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}