package com.uniquindio.taller_de_bicicletas.model;

import java.util.ArrayList;
import java.util.List;

public class Bicicleta {
    private String marca;
    private String color;
    private String numSerial;
    private String antiguedad;
    private Cliente cliente;
    private Tipo tipo;
    private List<OrdenServicio> listOrdenServiciosBicicleta;

    public Bicicleta(String marca, String color, String numSerial, String antiguedad, Tipo tipo){
        this.marca = marca;
        this.color = color;
        this.numSerial = numSerial;
        this.antiguedad = antiguedad;
        this.tipo = tipo;
        this.listOrdenServiciosBicicleta = new ArrayList<>();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumSerial() {
        return numSerial;
    }

    public void setNumSerial(String numSerial) {
        this.numSerial = numSerial;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<OrdenServicio> getListOrdenServiciosBicicleta() {
        return listOrdenServiciosBicicleta;
    }

    public void setListOrdenServiciosBicicleta(List<OrdenServicio> listOrdenServiciosBicicleta) {
        this.listOrdenServiciosBicicleta = listOrdenServiciosBicicleta;
    }
}
