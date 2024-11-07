package sk.ukf.testspeedrun;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Kapla extends Canvas {
    GraphicsContext gc;
    Timeline tl;

    public Kapla(double x, double y){
        super(30,30);
        gc = getGraphicsContext2D();
        setLayoutX(x+50);
        setLayoutY(y+50);
        draw();
        animStart();
    }
    public void draw(){
        gc.setFill(Color.BLUE);
        gc.fillOval(0,0,30,30);

    }

    public void animStart(){
        tl = new Timeline(new KeyFrame(Duration.millis(40), evt -> pad()));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();
    }

    private void pad(){
        setLayoutY(getLayoutY()+10);
        if(getLayoutY() >= getScene().getHeight()){
            del();
        }
    }

    private void del(){
        tl.stop();
        ((Group)getParent()).getChildren().remove(this);

    }
}
