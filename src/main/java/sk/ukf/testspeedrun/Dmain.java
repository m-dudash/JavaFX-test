package sk.ukf.testspeedrun;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Dmain extends Application {
    @Override
    public void start(Stage stage) {

        Group root = new Group();

        Drevo c = new Drevo(100,100);
        Jablko j = new Jablko(c);
        root.getChildren().addAll(c, j);

        Scene scene = new Scene(root, 800, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}