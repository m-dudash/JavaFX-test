package sk.ukf.testspeedrun;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Semafor extends Canvas {

    static int stav;
    GraphicsContext gc;
    Timeline tl;
    PSemafor p;

    public Semafor(int x, int y, PSemafor p){
        super(100,250);
        gc = getGraphicsContext2D();
        this.stav = 0;
        setLayoutY(y);
        setLayoutX(x);
        this.p = p;
        draw();
        animStart();
    }

    private void draw(){
        gc.clearRect(0,0,getWidth(), getHeight());
        gc.setFill(Color.DARKGRAY);
        gc.fillRect(0,0,100,250);
        gc.setFill(Color.BLACK);
        gc.fillOval(15,10,70,70);
        gc.fillOval(15,90,70,70);
        gc.fillOval(15,170,70,70);

        if(stav == 0){
            gc.setFill(Color.RED);
            gc.fillOval(15,10,70,70);
        }else if(stav == 1){
            gc.setFill(Color.RED);
            gc.fillOval(15,10,70,70);
            gc.setFill(Color.ORANGE);
            gc.fillOval(15,90,70,70);
        }
        else if(stav==2){
            gc.setFill(Color.GREEN);
            gc.fillOval(15,170,70,70);
        }else if(stav == 3){
            gc.setFill(Color.ORANGE);
            gc.fillOval(15,90,70,70);
        }
    }

    private void animStart(){
        tl = new Timeline(new KeyFrame(Duration.seconds(1), evt -> zmena()));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();
    }

    private void zmena(){
        stav = (stav+1) % 4;
        draw();
        if(stav == 1){
            p.zmena();
        }
        if(stav == 0){
            p.zmena();
        }
    }
}
