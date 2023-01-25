module com.brightstraining.javafxgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.brightstraining.javafxgame to javafx.fxml;
    exports com.brightstraining.javafxgame;
}