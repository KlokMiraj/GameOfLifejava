module com.example.gameoflife {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires eu.hansolo.tilesfx;
    requires java.datatransfer;
    requires java.desktop;

    opens com.example.gameoflife to javafx.fxml;
    exports com.example.gameoflife;
}