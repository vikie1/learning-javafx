package org.openjfx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createParent(), 500, 300));
        primaryStage.show();
    }
    
    private Parent createParent() {
        return new StackPane(new Text("Hello World"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
