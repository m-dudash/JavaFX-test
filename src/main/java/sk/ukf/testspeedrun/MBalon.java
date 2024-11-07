package sk.ukf.testspeedrun;

import javafx.scene.paint.Color;

public class MBalon extends Balony{

    public MBalon(double x, double y){
        super(40,60);
        gc = getGraphicsContext2D();
        setLayoutX(x);
        setLayoutY(y);

    }

    protected void draw(){
        super.draw();
        gc.setFill(Color.BLACK);
        gc.strokeLine(20,50,0,60);
        gc.setFill(cl);
        gc.fillOval(0,0,40,60);


    }
    protected void move(){
        draw();
        setLayoutY(getLayoutY()-2);
        if(getLayoutY() <= 0){
            this.del();
        }
    }
}
