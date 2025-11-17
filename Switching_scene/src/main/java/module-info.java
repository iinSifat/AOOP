module com.example.switching_scene {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.switching_scene to javafx.fxml;
    exports com.example.switching_scene;
}