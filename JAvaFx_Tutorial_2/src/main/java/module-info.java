module com.example.javafx_tutorial_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_tutorial_2 to javafx.fxml;
    exports com.example.javafx_tutorial_2;
}