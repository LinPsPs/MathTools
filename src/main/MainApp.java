package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Test");
        initRootLayout();
        initStartPage();
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Show start page inside the root layout
    public void initStartPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/StartPage.fxml"));
            AnchorPane startPage = (AnchorPane) loader.load();

            // put the pane into the center of the root layout
            rootLayout.setCenter(startPage);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //get the main stage
    public Stage getPrimaryStage() {
        return this.primaryStage;
    }
}
