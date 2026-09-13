package com.uniquindio.taller_de_bicicletas.model;

import java.util.ArrayList;
import java.util.List;

public class TallerBicicleta {
    private String nombre;
    public List<Repuesto> repuestos;
    public List<Persona> personas;
    public List<OrdenServicio> ordenServicios;
    public List<Bicicleta> bicicletas;


    public TallerBicicleta(String nombre){
        this.nombre = nombre;
        this.repuestos = new ArrayList<>();
        this.personas = new ArrayList<>();
        this.ordenServicios = new ArrayList<>();
        this.bicicletas = new ArrayList<>();
    }

    public List<OrdenServicio> consulOrdenProgramacion(String identificacionMecanico) {
        List<OrdenServicio> agendaMecanico = new ArrayList<>();
        for (OrdenServicio orden : ordenServicios) {
            if (orden.getMecanico() != null && orden.getMecanico().getIdentificacion().equals(identificacionMecanico)) {
                agendaMecanico.add(orden);
            }
        }
        return agendaMecanico;
    }

    public List<OrdenServicio> verHistorialServicio(String numSerial) {
        List<OrdenServicio> historial = new ArrayList<>();
        for (OrdenServicio orden : ordenServicios) {
            if (orden.getBicicleta() != null && orden.getBicicleta().getNumSerial().equals(numSerial)) {
                historial.add(orden);
            }
        }
        return historial;
    }

    public boolean crearOrdenServicio(OrdenServicio nuevaOrden) {
        boolean existe = false;
        for (OrdenServicio orden : ordenServicios) {
            if (orden.getCodigo() == nuevaOrden.getCodigo()) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            ordenServicios.add(nuevaOrden);
            return true;
        }
        return false;
    }

    public void mostrarAlertasStockBajo() {
        for (Repuesto repuesto : repuestos) {
            if (repuesto.stockBajo()) {
                System.out.println("Alerta: El repuesto " + repuesto.getNombre() +
                        " tiene poco stock (" + repuesto.getCantidadStock() + " unidades).");
            }
        }
    }

    public boolean agregarPersona(Persona persona) {
        boolean centinela = false;
        if (!verificarPersona(persona.getIdentificacion())) {
            personas.add(persona);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarPersona(String identificacion) {
        boolean centinela = false;
        for (Persona persona : personas) {
            if (persona.getIdentificacion().equals(identificacion)) {
                personas.remove(persona);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarPersona(String identificacion, Persona actualizado) {
        boolean centinela = false;
        for (Persona persona : personas) {
            if (persona.getIdentificacion().equals(identificacion)) {
                persona.actualizarDatos(actualizado);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarPersona(String identificacion) {
        boolean centinela = false;
        for (Persona persona : personas) {
            if (persona.getIdentificacion().equals(identificacion)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Repuesto> getRepuestos() {
        return repuestos;
    }

    public void setRepuestos(List<Repuesto> repuestos) {
        this.repuestos = repuestos;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<OrdenServicio> getOrdenServicios() {
        return ordenServicios;
    }

    public void setOrdenServicios(List<OrdenServicio> ordenServicios) {
        this.ordenServicios = ordenServicios;
    }

    public List<Bicicleta> getBicicletas() {
        return bicicletas;
    }

    public void setBicicletas(List<Bicicleta> bicicletas) {
        this.bicicletas = bicicletas;
    }


}
