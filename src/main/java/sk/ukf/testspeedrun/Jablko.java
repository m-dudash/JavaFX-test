package sk.ukf.testspeedrun;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Jablko extends Canvas {
    Timeline tl;
    GraphicsContext gc;
    Drevo d;
    Color cl;


    public Jablko(Drevo d){
        super(40,40);
        gc = getGraphicsContext2D();
        this.cl = Color.RED;
        this.d = d;
        setLayoutX(d.getLayoutX() + 200);
        setLayoutY(d.getLayoutY()+200);
        draw();
        setOnMouseClicked(evt -> animStart());
    }

    private void draw(){
        gc.setFill(cl);
        gc.fillOval(0,0,40,40);
    }

    private void animStart(){
        tl = new Timeline(new KeyFrame(Duration.millis(40), evt -> pad()));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();
    }
    private void pad(){
        setLayoutY(getLayoutY() + 8);
        if(getLayoutY() > getScene().getHeight()-30){
            this.hni();
        }
    }

    private void hni(){
        tl.stop();
        this.cl = Color.ORANGE;
        draw();
        tl = new Timeline(new KeyFrame(Duration.seconds(3), evt -> del()));
        tl.play();
    }

    private void del(){
        Jablko j = new Jablko(d);
        ((Group)getParent()).getChildren().add(j);
        ((Group)getParent()).getChildren().remove(this);


    }
}
