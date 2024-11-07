package sk.ukf.testspeedrun;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class CHman extends Canvas {
    GraphicsContext gc;
    Boolean LR, PR, DR;

    public  CHman(int x, int y){
        super(100,200);
        gc = getGraphicsContext2D();
        setLayoutY(y);
        setLayoutX(x);
        LR = false;
        PR = false;
        DR = false;

        setFocusTraversable(true);
        requestFocus();

        setOnMouseClicked(evt -> reqF());
        setOnKeyPressed(evt->handler(evt));
        draw();
    }

    public void reqF(){
        this.requestFocus();
        Group grp = ((Group) getParent());
        for(var node : grp.getChildren()){
            if(node instanceof CHman){
                ((CHman) node).draw();
            }
        }
    }


    public void handler(KeyEvent ky){
        KeyCode c = ky.getCode();
        if(c == KeyCode.J){
            this.zmen('L');
        }else if(c == KeyCode.K){
            this.zmen('D');
        }
        else if(c == KeyCode.L){
            this.zmen('P');
        }
    }

    public void zmen(char n){
        if(n == 'P') {
            PR = !PR;
            draw();
        }else if(n == 'L'){
            LR = !LR;
            draw();
        }else if(n == 'D'){
            DR = !DR;
            draw();
        }
        System.out.println("zmena: " + n);
    }

//    public void zmenP(){
//
//
//    }
//    public void zmenL(){
//
//
//    }
//    public void drepni(){
//
//
//    }

    private void draw(){
        gc.clearRect(0,0,getWidth(),getHeight());
        if(this.isFocused()){
            gc.setFill(Color.RED);
            gc.strokeRect(0,0,getWidth(),getHeight());
        }
        gc.setFill(Color.BLACK);
        gc.setLineWidth(4);
        gc.strokeOval(20,0,30,30);
        gc.strokeLine(35,30,35,90);
        if(LR){
            gc.strokeLine(5,5,35,50);
        }else{
            gc.strokeLine(5,70,35,50);
        }
        if(PR){
            gc.strokeLine(60,5,35,50);
        }else{
            gc.strokeLine(60,70,35,50);
        }
        if(DR){
            gc.strokeLine(5,60,35,90);
            gc.strokeLine(60,60,35,90);
        }else{
            gc.strokeLine(5,120,35,90);
            gc.strokeLine(60,120,35,90);
        }


    }
}
