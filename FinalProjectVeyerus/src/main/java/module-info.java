module com.reeves.finalprojectveyerus {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.reeves.finalprojectveyerus to javafx.fxml;
    exports com.reeves.finalprojectveyerus;
}
