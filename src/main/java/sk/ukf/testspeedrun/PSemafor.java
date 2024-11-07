package sk.ukf.testspeedrun;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PSemafor extends Canvas {
    int stav;
    GraphicsContext gc;
    public PSemafor(int x, int y){
        super(100,250);
        gc = getGraphicsContext2D();
        this.stav = 1;
        setLayoutY(y);
        setLayoutX(x);
        draw();
    }
    public void zmena(){
        stav = (stav+1)%2;
        draw();
    }

    private void draw(){
        gc.clearRect(0,0,getWidth(), getHeight());
        gc.setFill(Color.DARKGRAY);
        gc.fillRect(0,0,100,250);
        gc.setFill(Color.BLACK);
        gc.fillOval(15,50,70,70);
//        gc.fillOval(15,90,70,70);
        gc.fillOval(15,130,70,70);

        if(stav == 0){
            gc.setFill(Color.RED);
            gc.fillOval(15,50,70,70);
        }else if(stav == 1){
            gc.setFill(Color.GREEN);
            gc.fillOval(15,130,70,70);
        }

    }
}
