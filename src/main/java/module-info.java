module com.example.flappybirdd {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.google.gson;

    // Mở package ObjectGson.GsonForClient và ObjectGson.GsonForServer cho module com.google.gson
    opens ObjectGson.GsonForClient to com.google.gson;
    opens ObjectGson.GsonForServer to com.google.gson; // Thêm dòng này

    opens controller.flappybirdd to javafx.fxml;
    exports controller.flappybirdd;
}
