module com.example.menuitem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.menuitem to javafx.fxml;
    exports com.example.menuitem;
}