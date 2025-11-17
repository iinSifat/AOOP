module com.example.postwithgpt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.postwithgpt to javafx.fxml;
    exports com.example.postwithgpt;
}