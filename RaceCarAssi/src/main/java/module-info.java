module com.reeves.racecarassi {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.reeves.racecarassi to javafx.fxml;
    exports com.reeves.racecarassi;
}
