package sk.ukf.testspeedrun;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Chmara extends Canvas {
    GraphicsContext gc;

    public Chmara(int y){
        super(100,70);
        gc = getGraphicsContext2D();
        setFocusTraversable(true);
        requestFocus();
        setLayoutY(y);
        setLayoutX(20);
        setOnKeyPressed(evt -> spracuj(evt));

        draw();

    }

    private void draw(){
        gc.setFill(Color.LIGHTBLUE);
        gc.fillOval(0,0,80,50);
        gc.fillOval(10,20,80,60);


    }

    public void spracuj(KeyEvent ky){
        KeyCode c = ky.getCode();
        if(c == KeyCode.LEFT){
            move(-10);
        }
        else if(c == KeyCode.RIGHT){
            move(10);
        } else if (c == KeyCode.SPACE) {
            Kapla k = new Kapla(getLayoutX(), getLayoutY());
            ((Group)getParent()).getChildren().add(k);
        }
    }

    private void move(int n){
        setLayoutX(getLayoutX() + n);
        if(getLayoutX() >= getScene().getWidth()){
            setLayoutX(0);

        }else if(getLayoutX() <= 0){
            setLayoutX(getScene().getWidth());
        }


    }
}
