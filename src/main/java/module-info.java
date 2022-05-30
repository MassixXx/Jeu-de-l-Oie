module com.example.goose {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.goose to javafx.fxml;
    exports com.example.goose;
    exports Kernel;
}