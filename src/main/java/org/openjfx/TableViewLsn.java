package org.openjfx;

import org.openjfx.util.Item;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewLsn extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TableView<Item> tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox.setVgrow(tableView, Priority.ALWAYS);

        TableColumn<Item, String> columnSku = new TableColumn<>("SKU");
        TableColumn<Item, String> columnDescr = new TableColumn<>("Item");
        TableColumn<Item, Float> columnPrice = new TableColumn<>("Price");
        TableColumn<Item, Boolean> columnTax = new TableColumn<>("Tax");

        tableView.getColumns().addAll(columnSku, columnDescr, columnPrice, columnTax);

        tableView.getItems().addAll(new Item("KBD-0455892", "Mechanical Keyboard", 100.0f, true),
                new Item("145256", "Product Docs", 0.0f, false), new Item("OR-198975", "O-Ring (100)", 10.0f, true));
        columnSku.setCellValueFactory(new PropertyValueFactory<>("sku"));
        columnDescr.setCellValueFactory(new PropertyValueFactory<>("descr"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnTax.setCellValueFactory(new PropertyValueFactory<>("taxable"));

        Button inventoryButton = new Button("Inventory");
        Button taxButton = new Button("Tax");

        inventoryButton.disableProperty().bind(
            tableView.getSelectionModel().selectedItemProperty().isNull()
        );

        taxButton.disableProperty().bind(
            tableView.getSelectionModel().selectedItemProperty().isNull().or(
                Bindings.select(
                    tableView.getSelectionModel().selectedItemProperty(),
                    "taxable"
                ).isEqualTo(false)
            )
        );

        HBox hBox = new HBox(inventoryButton, taxButton);
        hBox.setSpacing(8);

        VBox vbox = new VBox(tableView, hBox);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        Scene scene = new Scene(vbox);

        primaryStage.setTitle("table demostration");
        primaryStage.setHeight(376);
        primaryStage.setWidth(667);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
