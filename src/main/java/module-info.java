module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jgrapht.core;

    opens app to javafx.fxml;
    opens app.controladores to javafx.fxml;
    exports app;
}