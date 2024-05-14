module com.example.flappybirdd {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens controller.flappybirdd to javafx.fxml;
    exports controller.flappybirdd;

}