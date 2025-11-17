module com.example.appclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.appclient to javafx.fxml;
    exports com.example.appclient;
}