package com.uniquindio.taller_de_bicicletas.controller;

import com.uniquindio.taller_de_bicicletas.model.*;
import java.util.ArrayList;
import java.util.List;

public class TallerController {

    private TallerBicicleta tallerBicicleta;

    public TallerController(TallerBicicleta tallerBicicleta) {
        this.tallerBicicleta = tallerBicicleta;
    }

    // --- CLIENTES ---
    public boolean agregarCliente(Cliente cliente) {
        return tallerBicicleta.agregarPersona(cliente);
    }

    public boolean eliminarCliente(String identificacion) {
        return tallerBicicleta.eliminarPersona(identificacion);
    }

    public boolean actualizarCliente(String identificacion, Cliente cliente) {
        return tallerBicicleta.actualizarPersona(identificacion, cliente);
    }

    public List<Cliente> obtenerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        for (Persona p : tallerBicicleta.getPersonas()) {
            if (p instanceof Cliente) {
                clientes.add((Cliente) p);
            }
        }
        return clientes;
    }

    // --- MECÁNICOS ---
    public boolean agregarMecanico(Mecanico mecanico) {
        return tallerBicicleta.agregarPersona(mecanico);
    }

    public boolean eliminarMecanico(String identificacion) {
        return tallerBicicleta.eliminarPersona(identificacion);
    }

    public boolean actualizarMecanico(String identificacion, Mecanico mecanico) {
        return tallerBicicleta.actualizarPersona(identificacion, mecanico);
    }

    public List<Mecanico> obtenerMecanicos() {
        List<Mecanico> mecanicos = new ArrayList<>();
        for (Persona p : tallerBicicleta.getPersonas()) {
            if (p instanceof Mecanico) {
                mecanicos.add((Mecanico) p);
            }
        }
        return mecanicos;
    }

    // --- BICICLETAS ---
    public boolean agregarBicicleta(Bicicleta bicicleta) {
        for (Bicicleta b : tallerBicicleta.getBicicletas()) {
            if (b.getNumSerial().equals(bicicleta.getNumSerial())) {
                return false;
            }
        }
        tallerBicicleta.getBicicletas().add(bicicleta);
        if (bicicleta.getCliente() != null) {
            bicicleta.getCliente().getListBicicletaClientes().add(bicicleta);
        }
        return true;
    }

    public List<Bicicleta> obtenerBicicletas() {
        return tallerBicicleta.getBicicletas();
    }

    // --- ÓRDENES DE SERVICIO ---
    public boolean crearOrdenServicio(OrdenServicio orden) {
        return tallerBicicleta.crearOrdenServicio(orden);
    }

    public List<OrdenServicio> obtenerOrdenesServicio() {
        return tallerBicicleta.getOrdenServicios();
    }

    public List<OrdenServicio> verHistorialServicio(String numSerial) {
        return tallerBicicleta.verHistorialServicio(numSerial);
    }

    public List<OrdenServicio> consulOrdenProgramacion(String identificacionMecanico) {
        return tallerBicicleta.consulOrdenProgramacion(identificacionMecanico);
    }

    // --- REPUESTOS / STOCK ---
    public List<Repuesto> obtenerRepuestos() {
        return tallerBicicleta.getRepuestos();
    }

    public boolean agregarRepuesto(Repuesto repuesto) {
        tallerBicicleta.getRepuestos().add(repuesto);
        return true;
    }
}
