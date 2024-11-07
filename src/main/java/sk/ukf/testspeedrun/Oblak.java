package sk.ukf.testspeedrun;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Oblak extends Application {
    @Override
    public void start(Stage stage) {

        Group root = new Group();

        Chmara c = new Chmara(30);
        root.getChildren().add(c);

        Scene scene = new Scene(root, 800, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}