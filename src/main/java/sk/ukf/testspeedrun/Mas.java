package sk.ukf.testspeedrun;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Mas extends Application {
    @Override
    public void start(Stage stage) {

        Group root = new Group();
        PSemafor p = new PSemafor(300,200);

        Semafor c = new Semafor(200,200, p);
        root.getChildren().addAll(c, p);

        Scene scene = new Scene(root, 800, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}