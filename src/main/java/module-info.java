module com.example.taller_de_bicicletas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uniquindio.taller_de_bicicletas to javafx.fxml;
    exports com.uniquindio.taller_de_bicicletas;
}