package sk.ukf.testspeedrun;

public class VBalon extends Balony{

    public VBalon(double x, double y){
        super(60,60);
        gc = getGraphicsContext2D();
        setLayoutX(x);
        setLayoutY(y);

    }

    protected void draw(){
        gc.clearRect(0,0,getWidth(), getHeight());
        super.draw();
        gc.setFill(cl);
        gc.fillOval(0,0,60,60);

    }
    protected void move(){
        draw();
        setLayoutY(getLayoutY()+2);
        if(getLayoutY() >= getScene().getHeight()){
            this.del();
        }
    }
}
