module com.example.simple_animation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.simple_animation to javafx.fxml;
    exports com.example.simple_animation;
}