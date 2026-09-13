package com.uniquindio.taller_de_bicicletas.model;

public class Repuesto {

    private String nombre;
    private int cantidadStock;
    private double precio;
    private OrdenServicio ordenServicio;

    public Repuesto(String nombre, int cantidadStock, double precio){
        this.nombre = nombre;
        this.cantidadStock = cantidadStock;
        this.precio = precio;
    }

    public boolean stockBajo() {
        if (this.cantidadStock <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public OrdenServicio getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(OrdenServicio ordenServicio) {
        this.ordenServicio = ordenServicio;
    }
}

