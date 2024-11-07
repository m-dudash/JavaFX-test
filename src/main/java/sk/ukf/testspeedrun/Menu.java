package sk.ukf.testspeedrun;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu extends Application {
    Group root;
    @Override

    public void start(Stage stage) {

        root = new Group();

        CHman c = new CHman(200,200);
        CHman e = new CHman(300,200);
        CHman f = new CHman(400,200);
        CHman kl = new CHman(500,200);


        Button l = new Button("LAVA");
        Button r = new Button("PRAVA");
        Button d = new Button("DRIPAJ");

        l.setOnAction(evt -> zmenene('L'));
        r.setOnAction(evt -> zmenene('P'));
        d.setOnAction(evt-> zmenene('D'));

        HBox kn = new HBox(10);
        kn.getChildren().addAll(l,r,d);
        root.getChildren().addAll(kn,c, e, f, kl);

        Scene scene = new Scene(root, 800, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void zmenene(char n){
        for(var node : root.getChildren()){
            if(node instanceof CHman){
                ((CHman) node).zmen(n);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}