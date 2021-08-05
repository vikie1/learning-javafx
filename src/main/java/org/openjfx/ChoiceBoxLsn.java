package org.openjfx;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.util.StringConverter;

public class ChoiceBoxLsn extends Application {

    private ChoiceBox<Pair<String, String>> pairChoice = new ChoiceBox<>();
    private ChoiceBox<String> choice = new ChoiceBox<>();
    private final Pair<String, String> EMPTY_PAIR = new Pair<>("", "");

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Choices you have");
        choice.setPrefWidth(200);
        String string = "";
        choice.getItems().add("hi");
        choice.getItems().add("victor");
        choice.getItems().add("laptop");
        choice.getItems().add(string);
        choice.setValue(string);
        Button saveButton = new Button("Save");
        HBox hbox = new HBox(label, choice, saveButton);
        hbox.setSpacing(10.0d);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(40));
        Scene scene = new Scene(hbox);
        //initChoice();
        saveButton.setOnAction(e -> {
            System.out.println("selected " + choice.getValue());
        });
        primaryStage.setTitle("Choice box lesson");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void initChoice() {
        List<Pair<String, String>> choices = new ArrayList<>();
        choices.add(new Pair<>("Victor", "1000"));
        choices.add(new Pair<>("Laptop", "great"));
        choices.add(new Pair<>("Furniture", "Last"));
        pairChoice.setConverter(new StringConverter<Pair<String, String>>() {

            @Override
            public String toString(Pair<String, String> object) {
                return object.getKey();
            }

            @Override
            public Pair<String, String> fromString(String string) {
                return null;
            }

        });
        pairChoice.getItems().add(EMPTY_PAIR);
        pairChoice.getItems().addAll(choices);
        pairChoice.setValue(EMPTY_PAIR);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
