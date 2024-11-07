package sk.ukf.testspeedrun;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Ded extends Application {
    Group root;
    @Override

    public void start(Stage stage) {

        root = new Group();
        Scene scene = new Scene(root, 800, 800);
        Random rnd = new Random();

        HBox kn = new HBox(10);
        Button V = new Button("VELKY");
        Button M = new Button("MALY");
        Button Z = new Button("CVET");
        Button P = new Button("POSUN");
        Z.setOnAction(evt -> cvet());
        P.setOnAction(evt -> posuvaj());
        M.setOnAction(evt ->{
            double x = rnd.nextDouble(0,scene.getWidth());
            double y = rnd.nextDouble(0,scene.getHeight());
            MBalon m = new MBalon(x, y);
            root.getChildren().add(m);
        });
        V.setOnAction(evt -> {
            double x = rnd.nextDouble(0,scene.getWidth());
            double y = rnd.nextDouble(0,scene.getHeight());
            VBalon vb = new VBalon(x, y);
            root.getChildren().add(vb);
        });

        kn.getChildren().addAll(V, M, Z, P);
        root.getChildren().addAll(kn);


        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void posuvaj(){
        for(var node : root.getChildren()){
            if (node instanceof Balony){
                ((Balony) node).posun();
            }
        }
    }

    public void cvet(){
        for(var node : root.getChildren()){
            if(node instanceof MBalon){
                ((MBalon) node).zmena();
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}