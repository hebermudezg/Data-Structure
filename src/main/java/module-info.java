module app {
    requires javafx.controls;
    requires javafx.fxml;

    opens app to javafx.fxml;
    opens app.controladores to javafx.fxml;
    exports app;
}