module sk.ukf.testspeedrun {
    requires javafx.controls;
    requires javafx.fxml;


    opens sk.ukf.testspeedrun to javafx.fxml;
    exports sk.ukf.testspeedrun;
}