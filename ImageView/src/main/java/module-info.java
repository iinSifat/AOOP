module com.example.imageview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.imageview to javafx.fxml;
    exports com.example.imageview;
}