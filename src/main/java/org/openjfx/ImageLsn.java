package org.openjfx;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ImageLsn extends Application {

    private final String IMAGE_LOC = "img/collaborate.jpg";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image(IMAGE_LOC, 360d, 360d, true, true);
        Image image2 = new Image(IMAGE_LOC, 360d, 360d, false, true);
        Image image3 = new Image(IMAGE_LOC);

        ImageView imageView = new ImageView(IMAGE_LOC);

        ImageView imageView2 = new ImageView(image);
        ImageView imageView3 = new ImageView(image2);
        ImageView imageView4 = new ImageView(image3);
        imageView4.setPreserveRatio(true);
        imageView4.setFitHeight(360);
        imageView4.setFitWidth(360);
        Rectangle2D rectangle = new Rectangle2D(20, 50, 100, 100);
        imageView4.setViewport(rectangle);
        Pane pane = new Pane(imageView);
        Scene scene = new Scene(pane);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
