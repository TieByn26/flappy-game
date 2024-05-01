module com.example.flappybirdd {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.flappybirdd to javafx.fxml;
    exports com.example.flappybirdd;
}