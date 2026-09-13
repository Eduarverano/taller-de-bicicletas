package com.uniquindio.taller_de_bicicletas.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{

    private String direccion;
    private List<Bicicleta> listBicicletaClientes;

    public Cliente(String nombre, long telefono, String identificacion, String direccion){
        super(nombre, telefono, identificacion);
        this.direccion = direccion;
        this.listBicicletaClientes = new ArrayList<>();
    }

    @Override
    public void actualizarDatos(Persona nuevosDatos) {
        Cliente nuevo = (Cliente) nuevosDatos;
        this.setNombre(nuevo.getNombre());
        this.setTelefono(nuevo.getTelefono());
        this.setIdentificacion(nuevo.getIdentificacion());
        this.direccion = nuevo.getDireccion();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Bicicleta> getListBicicletaClientes() {
        return listBicicletaClientes;
    }

    public void setListBicicletaClientes(List<Bicicleta> listBicicletaClientes) {
        this.listBicicletaClientes = listBicicletaClientes;
    }
}
