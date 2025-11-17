module com.example.socketprogrammngapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.socketprogrammngapp to javafx.fxml;
    exports com.example.socketprogrammngapp;
}