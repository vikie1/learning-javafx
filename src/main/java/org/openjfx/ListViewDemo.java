package org.openjfx;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.openjfx.util.Player;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //test data
        Player[] players = { new Player("BOS", "David Ortiz"), new Player("BOS", "Jackie Bradley Jr."),
                new Player("BOS", "Xander Bogarts"), new Player("BOS", "Mookie Betts"),
                new Player("HOU", "Jose Altuve"), new Player("HOU", "Will Harris"), new Player("WSH", "Max Scherzer"),
                new Player("WSH", "Bryce Harper"), new Player("WSH", "Daniel Murphy"),
                new Player("WSH", "Wilson Ramos") };
        //set up the model which is two lists of players and a filter criteria
        ReadOnlyObjectProperty<ObservableList<Player>> observableListProperty = new SimpleObjectProperty<>(
                FXCollections.observableArrayList());
        ReadOnlyObjectProperty<FilteredList<Player>> filteredListProperty = new SimpleObjectProperty<FilteredList<Player>>(
                new FilteredList<>(observableListProperty.get()));
        ObjectProperty<Predicate<? super Player>> predicateProperty = filteredListProperty.get().predicateProperty();

        // build the ui

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(4);

        HBox hBox = new HBox();
        hBox.setSpacing(2);

        ToggleGroup filterToggleGroup = new ToggleGroup();

        //the toggleHandler will be used to set the filter based on the toggleButton selected
        @SuppressWarnings("unchecked")
        EventHandler<ActionEvent> toggleHandler = (event) -> {
            ToggleButton toggleButton = (ToggleButton) event.getSource();
            Predicate<Player> filter = (Predicate<Player>) toggleButton.getUserData();
            predicateProperty.set(filter);
        };
        ToggleButton showAll = new ToggleButton("show all");
        showAll.setSelected(true);
        showAll.setToggleGroup(filterToggleGroup);
        showAll.setOnAction(toggleHandler);
        showAll.setUserData((Predicate<Player>) (Player player) -> true);

        //create a distinct list of player objects then create the toggleButtons
        List<ToggleButton> toggleButtons = Arrays.asList(players).stream().map(player -> player.getTeam()).distinct().map(team -> {
            ToggleButton toggleButton = new ToggleButton(team);
            toggleButton.setToggleGroup(filterToggleGroup);
            toggleButton.setOnAction(toggleHandler);
            toggleButton.setUserData((Predicate<Player>)(Player player) -> team.equals(player.getTeam()));
            return toggleButton;
        }).collect(Collectors.toList());
        hBox.getChildren().add(showAll);
        hBox.getChildren().addAll(toggleButtons);

        //create a listView bound to the viewablePlayers property
        ListView<Player> listView = new ListView<>();
        listView.itemsProperty().bind(filteredListProperty);

        vbox.getChildren().addAll(hBox, listView);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setOnShown((event) -> {
            observableListProperty.get().addAll(players);
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
