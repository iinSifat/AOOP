module com.example.messengerapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.messengerapp to javafx.fxml;
    exports com.example.messengerapp;
}