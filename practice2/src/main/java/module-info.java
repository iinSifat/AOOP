module com.example.practice2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practice2 to javafx.fxml;
    exports com.example.practice2;
}