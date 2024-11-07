package sk.ukf.testspeedrun;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Drevo extends Canvas {
    GraphicsContext gc;

    public Drevo(int x, int y){
        super(400,800);
        gc = getGraphicsContext2D();
        setLayoutX(x);
        setLayoutY(y);
        draw();
    }

    private void draw(){
        gc.setStroke(Color.BROWN);
        gc.setLineWidth(70);
        gc.strokeLine(230,100,230,800);
        gc.setFill(Color.GREEN);
        gc.fillOval(70,30,300,300);
    }
}
