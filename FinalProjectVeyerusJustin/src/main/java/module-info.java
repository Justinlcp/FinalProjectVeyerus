module com.mycompany.finalprojectveyerusjustin {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.finalprojectveyerusjustin to javafx.fxml;
    exports com.mycompany.finalprojectveyerusjustin;
}
