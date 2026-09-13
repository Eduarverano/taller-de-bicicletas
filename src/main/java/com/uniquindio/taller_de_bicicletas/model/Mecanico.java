package com.uniquindio.taller_de_bicicletas.model;

import java.util.ArrayList;
import java.util.List;

public class Mecanico extends Persona{

    private int codigo;
    private Especialidad especialidad;
    private List<OrdenServicio> listOrdenServiciosMecanico;

    public Mecanico(String nombre, long telefono, String identificacion, int codigo, Especialidad especialidad){
        super(nombre, telefono, identificacion);
        this.codigo = codigo;
        this.especialidad = especialidad;
        this.listOrdenServiciosMecanico = new ArrayList<>();
    }

    @Override
    public void actualizarDatos(Persona nuevosDatos) {
        Mecanico nuevo = (Mecanico) nuevosDatos;
        this.setNombre(nuevo.getNombre());
        this.setTelefono(nuevo.getTelefono());
        this.setIdentificacion(nuevo.getIdentificacion());
        this.especialidad = nuevo.getEspecialidad();
        this.codigo = nuevo.getCodigo();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<OrdenServicio> getListOrdenServiciosMecanico() {
        return listOrdenServiciosMecanico;
    }

    public void setListOrdenServiciosMecanico(List<OrdenServicio> listOrdenServiciosMecanico) {
        this.listOrdenServiciosMecanico = listOrdenServiciosMecanico;
    }
}
