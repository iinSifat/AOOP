module com.example.image_view {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.image_view to javafx.fxml;
    exports com.example.image_view;
}