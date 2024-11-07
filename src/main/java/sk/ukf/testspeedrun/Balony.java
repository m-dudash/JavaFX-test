package sk.ukf.testspeedrun;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.Random;

public abstract class Balony extends Canvas {
    Color cl;
    GraphicsContext gc;
    Timeline tl;
    Random rnd = new Random();

    protected Balony(double width, double height){
        super(width,height);
        gc = getGraphicsContext2D();
        this.cl = Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255) );
        draw();
        animStart();
        setFocusTraversable(true);
        setOnKeyPressed(evt -> handler(evt));
        setOnMouseClicked(evt ->{
            requestFocus();
            draw();
        });

    }

    protected void handler(KeyEvent ky){
        KeyCode c = ky.getCode();
        if(c == KeyCode.DELETE){
            this.del();
        }
    }

    protected  void draw(){
        gc.clearRect(0,0,getWidth(),getHeight());
        if(this.isFocused()){
            gc.setFill(Color.RED);
            gc.strokeRect(0,0,getWidth(), getHeight());
        }
    };
    protected abstract void move();

    protected void animStart(){
        tl = new Timeline(new KeyFrame(Duration.millis(50), evt -> move()));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();
    }

    protected void del(){
        ((Group)getParent()).getChildren().remove(this);
        tl.stop();
    }

    public void zmena(){
        this.cl = Color.MAGENTA;
        draw();

    }

    public void posun(){
        setLayoutX(getLayoutX() + 20);
        if(getLayoutX() > getScene().getHeight()){
            del();
        }

    }
}
