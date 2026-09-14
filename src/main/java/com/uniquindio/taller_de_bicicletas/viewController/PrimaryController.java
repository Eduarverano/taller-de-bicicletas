package com.uniquindio.taller_de_bicicletas.viewController;

import com.uniquindio.taller_de_bicicletas.App;
import com.uniquindio.taller_de_bicicletas.controller.TallerController;
import com.uniquindio.taller_de_bicicletas.model.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class PrimaryController {

    private App app;
    private TallerController controller;

    // --- OBSERVABLE LISTS ---
    private ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
    private ObservableList<Mecanico> listMecanicos = FXCollections.observableArrayList();
    private ObservableList<Bicicleta> listBicicletas = FXCollections.observableArrayList();
    private ObservableList<OrdenServicio> listOrdenes = FXCollections.observableArrayList();
    private ObservableList<Repuesto> listRepuestos = FXCollections.observableArrayList();

    // --- TAB CLIENTES ---
    @FXML private TextField txtClienteNombre, txtClienteID, txtClienteTelefono, txtClienteDireccion;
    @FXML private TableView<Cliente> tblClientes;
    @FXML private TableColumn<Cliente, String> colClienteID, colClienteNombre, colClienteTelefono, colClienteDireccion;

    // --- TAB MECÁNICOS ---
    @FXML private TextField txtMecanicoNombre, txtMecanicoID, txtMecanicoTelefono, txtMecanicoCodigo;
    @FXML private ComboBox<Especialidad> cbMecanicoEspecialidad;
    @FXML private TableView<Mecanico> tblMecanicos;
    @FXML private TableColumn<Mecanico, String> colMecanicoID, colMecanicoNombre, colMecanicoTelefono, colMecanicoEspecialidad;
    @FXML private TableColumn<Mecanico, Integer> colMecanicoCodigo;

    // --- TAB BICICLETAS ---
    @FXML private TextField txtBiciMarca, txtBiciColor, txtBiciSerial, txtBiciAntiguedad;
    @FXML private ComboBox<Tipo> cbBiciTipo;
    @FXML private ComboBox<Cliente> cbBiciCliente;
    @FXML private TableView<Bicicleta> tblBicicletas;
    @FXML private TableColumn<Bicicleta, String> colBiciSerial, colBiciMarca, colBiciColor, colBiciAntiguedad, colBiciTipo, colBiciCliente;

    // --- TAB ÓRDENES DE SERVICIO ---
    @FXML private TextField txtOrdenCodigo, txtOrdenHora, txtOrdenMotivo, txtOrdenDiagnostico, txtOrdenTrabajo, txtOrdenCosto;
    @FXML private DatePicker dpOrdenFecha;
    @FXML private ComboBox<Bicicleta> cbOrdenBici;
    @FXML private ComboBox<Mecanico> cbOrdenMecanico;
    @FXML private TableView<OrdenServicio> tblOrdenes;
    @FXML private TableColumn<OrdenServicio, Integer> colOrdenCodigo;
    @FXML private TableColumn<OrdenServicio, LocalDate> colOrdenFecha;
    @FXML private TableColumn<OrdenServicio, String> colOrdenBici, colOrdenMecanico, colOrdenMotivo, colOrdenTrabajo;
    @FXML private TableColumn<OrdenServicio, Double> colOrdenCosto;

    // --- TAB CONSULTAS & ALERTAS ---
    @FXML private TextField txtBuscarSerialBici, txtBuscarIDMecanico;
    @FXML private TableView<OrdenServicio> tblHistorialBici, tblAgendaMecanico;
    @FXML private TableColumn<OrdenServicio, Integer> colHistCodigo, colAgendaCodigo;
    @FXML private TableColumn<OrdenServicio, String> colHistMotivo, colAgendaMotivo, colHistTrabajo, colAgendaTrabajo;
    @FXML private TableView<Repuesto> tblStockBajo;
    @FXML private TableColumn<Repuesto, String> colRepuestoNombre;
    @FXML private TableColumn<Repuesto, Integer> colRepuestoStock;
    @FXML private TableColumn<Repuesto, Double> colRepuestoPrecio;

    public void setApp(App app) {
        this.app = app;
        this.controller = new TallerController(App.tallerBicicleta);
        initView();
    }

    private void initView() {
        // Enums para ComboBoxes
        cbMecanicoEspecialidad.setItems(FXCollections.observableArrayList(Especialidad.values()));
        cbBiciTipo.setItems(FXCollections.observableArrayList(Tipo.values()));

        // Bindings de Tablas
        initDataBindings();

        // Cargar Datos Iniciales
        actualizarListas();
    }

    private void initDataBindings() {
        // Clientes
        colClienteID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        colClienteNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colClienteTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTelefono())));
        colClienteDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));

        // Mecánicos
        colMecanicoID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        colMecanicoNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colMecanicoTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTelefono())));
        colMecanicoCodigo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCodigo()));
        colMecanicoEspecialidad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEspecialidad().toString()));

        // Bicicletas
        colBiciSerial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumSerial()));
        colBiciMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        colBiciColor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getColor()));
        colBiciAntiguedad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAntiguedad()));
        colBiciTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipo() != null ? cellData.getValue().getTipo().toString() : ""));
        colBiciCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente() != null ? cellData.getValue().getCliente().getNombre() : ""));

        // Órdenes
        colOrdenCodigo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCodigo()));
        colOrdenFecha.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFechaIngreso()));
        colOrdenBici.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBicicleta() != null ? cellData.getValue().getBicicleta().getNumSerial() : ""));
        colOrdenMecanico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMecanico() != null ? cellData.getValue().getMecanico().getNombre() : ""));
        colOrdenMotivo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMotivoServicio()));
        colOrdenTrabajo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTrabajoRealizado()));
        colOrdenCosto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCostoTotal()));

        // Consultas
        colHistCodigo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCodigo()));
        colHistMotivo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMotivoServicio()));
        colHistTrabajo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTrabajoRealizado()));

        colAgendaCodigo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCodigo()));
        colAgendaMotivo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMotivoServicio()));
        colAgendaTrabajo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTrabajoRealizado()));

        // Stock bajo
        colRepuestoNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colRepuestoStock.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCantidadStock()));
        colRepuestoPrecio.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrecio()));
    }

    private void actualizarListas() {
        listClientes.setAll(controller.obtenerClientes());
        tblClientes.setItems(listClientes);
        cbBiciCliente.setItems(listClientes);

        listMecanicos.setAll(controller.obtenerMecanicos());
        tblMecanicos.setItems(listMecanicos);
        cbOrdenMecanico.setItems(listMecanicos);

        listBicicletas.setAll(controller.obtenerBicicletas());
        tblBicicletas.setItems(listBicicletas);
        cbOrdenBici.setItems(listBicicletas);

        listOrdenes.setAll(controller.obtenerOrdenesServicio());
        tblOrdenes.setItems(listOrdenes);

        // Alertas de Stock Bajo (stock <= 5)
        ObservableList<Repuesto> stockBajo = FXCollections.observableArrayList();
        for (Repuesto r : controller.obtenerRepuestos()) {
            if (r.stockBajo()) {
                stockBajo.add(r);
            }
        }
        tblStockBajo.setItems(stockBajo);
    }

    // ==================== ACCIONES CLIENTES ====================
    @FXML
    void onAgregarCliente() {
        try {
            Cliente c = new Cliente(
                    txtClienteNombre.getText(),
                    Long.parseLong(txtClienteTelefono.getText()),
                    txtClienteID.getText(),
                    txtClienteDireccion.getText()
            );
            if (controller.agregarCliente(c)) {
                actualizarListas();
                limpiarCamposCliente();
            } else {
                mostrarAlerta("Error", "El cliente con esa identificación ya existe.");
            }
        } catch (Exception e) {
            mostrarAlerta("Error de Formato", "Por favor verifique los campos ingresados.");
        }
    }

    @FXML
    void onEliminarCliente() {
        Cliente seleccionado = tblClientes.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            controller.eliminarCliente(seleccionado.getIdentificacion());
            actualizarListas();
            limpiarCamposCliente();
        }
    }

    private void limpiarCamposCliente() {
        txtClienteNombre.clear();
        txtClienteID.clear();
        txtClienteTelefono.clear();
        txtClienteDireccion.clear();
    }

    // ==================== ACCIONES MECÁNICOS ====================
    @FXML
    void onAgregarMecanico() {
        try {
            Mecanico m = new Mecanico(
                    txtMecanicoNombre.getText(),
                    Long.parseLong(txtMecanicoTelefono.getText()),
                    txtMecanicoID.getText(),
                    Integer.parseInt(txtMecanicoCodigo.getText()),
                    cbMecanicoEspecialidad.getValue()
            );
            if (controller.agregarMecanico(m)) {
                actualizarListas();
                limpiarCamposMecanico();
            } else {
                mostrarAlerta("Error", "El mecánico ya existe.");
            }
        } catch (Exception e) {
            mostrarAlerta("Error", "Verifique los datos de ingreso.");
        }
    }

    @FXML
    void onEliminarMecanico() {
        Mecanico seleccionado = tblMecanicos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            controller.eliminarMecanico(seleccionado.getIdentificacion());
            actualizarListas();
            limpiarCamposMecanico();
        }
    }

    private void limpiarCamposMecanico() {
        txtMecanicoNombre.clear();
        txtMecanicoID.clear();
        txtMecanicoTelefono.clear();
        txtMecanicoCodigo.clear();
        cbMecanicoEspecialidad.setValue(null);
    }

    // ==================== ACCIONES BICICLETAS ====================
    @FXML
    void onAgregarBicicleta() {
        try {
            Bicicleta b = new Bicicleta(
                    txtBiciMarca.getText(),
                    txtBiciColor.getText(),
                    txtBiciSerial.getText(),
                    txtBiciAntiguedad.getText(),
                    cbBiciTipo.getValue()
            );
            b.setCliente(cbBiciCliente.getValue());
            if (controller.agregarBicicleta(b)) {
                actualizarListas();
                limpiarCamposBici();
            } else {
                mostrarAlerta("Error", "La bicicleta con ese número serial ya está registrada.");
            }
        } catch (Exception e) {
            mostrarAlerta("Error", "Verifique los datos de la bicicleta.");
        }
    }

    private void limpiarCamposBici() {
        txtBiciMarca.clear();
        txtBiciColor.clear();
        txtBiciSerial.clear();
        txtBiciAntiguedad.clear();
        cbBiciTipo.setValue(null);
        cbBiciCliente.setValue(null);
    }

    // ==================== ACCIONES ÓRDENES DE SERVICIO ====================
    @FXML
    void onCrearOrden() {
        try {
            OrdenServicio orden = new OrdenServicio(
                    dpOrdenFecha.getValue(),
                    txtOrdenHora.getText(),
                    txtOrdenMotivo.getText(),
                    txtOrdenDiagnostico.getText(),
                    txtOrdenTrabajo.getText(),
                    Double.parseDouble(txtOrdenCosto.getText()),
                    Integer.parseInt(txtOrdenCodigo.getText())
            );
            orden.setBicicleta(cbOrdenBici.getValue());
            orden.setMecanico(cbOrdenMecanico.getValue());

            if (controller.crearOrdenServicio(orden)) {
                actualizarListas();
                limpiarCamposOrden();
            } else {
                mostrarAlerta("Error", "Ya existe una orden con ese código.");
            }
        } catch (Exception e) {
            mostrarAlerta("Error", "Verifique todos los campos de la orden.");
        }
    }

    private void limpiarCamposOrden() {
        txtOrdenCodigo.clear();
        txtOrdenHora.clear();
        txtOrdenMotivo.clear();
        txtOrdenDiagnostico.clear();
        txtOrdenTrabajo.clear();
        txtOrdenCosto.clear();
        dpOrdenFecha.setValue(null);
        cbOrdenBici.setValue(null);
        cbOrdenMecanico.setValue(null);
    }

    // ==================== ACCIONES CONSULTAS ====================
    @FXML
    void onBuscarHistorialBici() {
        String serial = txtBuscarSerialBici.getText();
        if (serial != null && !serial.trim().isEmpty()) {
            tblHistorialBici.setItems(FXCollections.observableArrayList(controller.verHistorialServicio(serial)));
        }
    }

    @FXML
    void onBuscarAgendaMecanico() {
        String id = txtBuscarIDMecanico.getText();
        if (id != null && !id.trim().isEmpty()) {
            tblAgendaMecanico.setItems(FXCollections.observableArrayList(controller.consulOrdenProgramacion(id)));
        }
    }

    private void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
