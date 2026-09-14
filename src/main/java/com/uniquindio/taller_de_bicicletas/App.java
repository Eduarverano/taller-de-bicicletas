package com.uniquindio.taller_de_bicicletas;

import com.uniquindio.taller_de_bicicletas.model.*;
import com.uniquindio.taller_de_bicicletas.viewController.PrimaryController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.TabPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class App extends Application {

    private Stage primaryStage;
    public static TallerBicicleta tallerBicicleta = new TallerBicicleta("Taller UQ");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Sistema de Gestión de Taller de Bicicletas - UQ");
        inicializarData();
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primaryView.fxml"));
            TabPane rootLayout = loader.load();

            PrimaryController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inicializarData() {
        // Clientes de prueba
        Cliente cliente1 = new Cliente("Carlos Pérez", 3101234567L, "1094001", "Calle 10 #12-15");
        Cliente cliente2 = new Cliente("María Gómez", 3209876543L, "1094002", "Carrera 15 #8-20");
        tallerBicicleta.agregarPersona(cliente1);
        tallerBicicleta.agregarPersona(cliente2);

        // Mecánicos de prueba
        Mecanico mecanico1 = new Mecanico("Juan Rodríguez", 3155551234L, "1094003", 101, Especialidad.FRENOSYTRANSMISION);
        Mecanico mecanico2 = new Mecanico("Andrés López", 3167778899L, "1094004", 102, Especialidad.BICICLETASELECTRICAS);
        tallerBicicleta.agregarPersona(mecanico1);
        tallerBicicleta.agregarPersona(mecanico2);

        // Bicicletas
        Bicicleta bici1 = new Bicicleta("GW", "Negro/Rojo", "GW-1001", "2 años", Tipo.MTB);
        bici1.setCliente(cliente1);
        cliente1.getListBicicletaClientes().add(bici1);
        tallerBicicleta.getBicicletas().add(bici1);

        // Repuestos
        Repuesto r1 = new Repuesto("Cadena Shimano", 4, 85000.0); // Activa alerta de stock bajo
        Repuesto r2 = new Repuesto("Pastillas de Freno", 15, 35000.0);
        tallerBicicleta.getRepuestos().add(r1);
        tallerBicicleta.getRepuestos().add(r2);

        // Orden de Servicio
        OrdenServicio orden1 = new OrdenServicio(LocalDate.now(), "09:00", "Mantenimiento general", "Desgaste de frenos", "Cambio de guayas y ajuste", 120000.0, 501);
        orden1.setBicicleta(bici1);
        orden1.setMecanico(mecanico1);
        tallerBicicleta.crearOrdenServicio(orden1);
    }

    public static void main(String[] args) {
        launch();
    }
}







