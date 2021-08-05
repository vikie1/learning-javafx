package org.openjfx;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OnshownTrial extends Application {

    private DoubleProperty startx = new SimpleDoubleProperty();
    private DoubleProperty starty = new SimpleDoubleProperty();
    private DoubleProperty endx = new SimpleDoubleProperty();
    private DoubleProperty endy = new SimpleDoubleProperty();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Uninitialised dimensions");
        TextField textField = new TextField();
        textField.textProperty().bind(
            Bindings.format("(%.1f, %.1f)", startx, starty)
        );
        Label secondLabel = new Label("final dimensions");
        TextField secondTextField = new TextField();
        secondTextField.textProperty().bind(
            Bindings.format("(%.1f, %.1f)", endx, endy)
        );
        GridPane gridPane = new GridPane();
        gridPane.add(label, 0, 0);
        gridPane.add(textField, 1, 0);
        gridPane.add(secondLabel, 0, 1);
        gridPane.add(secondTextField, 1, 1);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        HBox hBox = new HBox(gridPane);
        hBox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(hBox);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox, 480, 320);
        primaryStage.setScene(scene);
        //before show() this should be executed
        startx.set(primaryStage.getWidth());
        starty.set(primaryStage.getHeight());
        primaryStage.setOnShown((e) -> {//this will be executed after show()
            System.out.println("this was executed");
            endx.set(primaryStage.getWidth());
            endy.set(primaryStage.getHeight());
        });
        primaryStage.setTitle("Initial vs End");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
