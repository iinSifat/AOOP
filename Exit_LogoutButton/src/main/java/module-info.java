module com.example.exit_logoutbutton {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exit_logoutbutton to javafx.fxml;
    exports com.example.exit_logoutbutton;
}