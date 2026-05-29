module com.javagames {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.javagames to javafx.fxml;
    exports com.javagames;
}
