module com.example.postdbms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.postdbms to javafx.fxml;
    exports com.example.postdbms;
}