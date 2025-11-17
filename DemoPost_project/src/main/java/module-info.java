module com.example.demopost_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demopost_project to javafx.fxml;
    exports com.example.demopost_project;
}