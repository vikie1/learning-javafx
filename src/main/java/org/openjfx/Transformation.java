package org.openjfx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Transformation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createParent(), 300, 300, Color.GOLD));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private Parent createParent(){
        Rectangle rectangle = new Rectangle(100, 50, Color.BLUEVIOLET);
        rectangle.setOnMouseClicked(e -> {
            transform(rectangle);
        });
        return new Pane(rectangle);
    }

    private void transform(Rectangle rectangle) {
        rectangle.setTranslateX(100);
        rectangle.setTranslateY(200);
        rectangle.setScaleX(1.2);
        rectangle.setScaleY(1.5);
        rectangle.setRotate(115);
    }
}
