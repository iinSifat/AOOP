module com.example.mainapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mainapp to javafx.fxml;
    exports com.example.mainapp;
}