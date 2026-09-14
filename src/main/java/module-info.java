module com.uniquindio.taller_de_bicicletas {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.uniquindio.taller_de_bicicletas to javafx.fxml;
    opens com.uniquindio.taller_de_bicicletas.model to javafx.fxml, javafx.base;
    opens com.uniquindio.taller_de_bicicletas.viewController to javafx.fxml;

    exports com.uniquindio.taller_de_bicicletas;
    exports com.uniquindio.taller_de_bicicletas.controller;
    exports com.uniquindio.taller_de_bicicletas.model;
    exports com.uniquindio.taller_de_bicicletas.viewController;
}