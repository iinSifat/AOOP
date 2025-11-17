module com.example.loginwithdbms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.loginwithdbms to javafx.fxml;
    exports com.example.loginwithdbms;
}