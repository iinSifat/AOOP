module com.example.samplelogin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.samplelogin to javafx.fxml;
    exports com.example.samplelogin;
}