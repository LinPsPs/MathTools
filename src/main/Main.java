/**
 * @author Haolin Yu
 */

package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("GrahamScan");
        GridPane root = new GridPane();
        root.setVgap(50);
        root.setHgap(100);
        primaryStage.setScene(new Scene(root, 300, 275));
        // Add a VBox to contain options
        VBox optionBox = new VBox();
        optionBox.setSpacing(10);
        optionBox.setPadding(new Insets(0, 20, 10, 20));
        root.add(optionBox, 0, 0);
        // Add Graham Scan to the root pane.
        initGrahamScanButton(optionBox);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void initGrahamScanButton(VBox root) {
        Button grahamScanButton = new Button();
        grahamScanButton.setText("Graham Scan");
        grahamScanButton.setOnMouseClicked(e -> {
            System.out.println("Start!");
            //(new GrahamScan()).start();
        });
        root.getChildren().add(grahamScanButton);
    }
}
