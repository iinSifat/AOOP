module com.example.simpleanimation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.simpleanimation to javafx.fxml;
    exports com.example.simpleanimation;
}