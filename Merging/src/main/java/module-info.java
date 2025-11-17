module com.example.merging {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.merging to javafx.fxml;
    exports com.example.merging;
}