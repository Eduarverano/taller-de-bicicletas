package com.uniquindio.taller_de_bicicletas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdenServicio {

    private LocalDate fechaIngreso;
    private String hora;
    private String motivoServicio;
    private String diagnostico;
    private String trabajoRealizado;
    private double costoTotal;
    private int codigo;
    private Bicicleta bicicleta;
    private Mecanico mecanico;
    private List<Repuesto> listRepuestoOrdenServicio;

    public OrdenServicio(LocalDate fechaIngreso, String hora, String motivoServicio, String diagnostico, String trabajoRealizado, double costoTotal, int codigo){
        this.fechaIngreso = fechaIngreso;
        this.hora = hora;
        this.motivoServicio = motivoServicio;
        this.diagnostico = diagnostico;
        this.trabajoRealizado = trabajoRealizado;
        this.costoTotal = costoTotal;
        this.codigo = codigo;
        this.listRepuestoOrdenServicio = new ArrayList<>();
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivoServicio() {
        return motivoServicio;
    }

    public void setMotivoServicio(String motivoServicio) {
        this.motivoServicio = motivoServicio;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTrabajoRealizado() {
        return trabajoRealizado;
    }

    public void setTrabajoRealizado(String trabajoRealizado) {
        this.trabajoRealizado = trabajoRealizado;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public List<Repuesto> getListRepuestoOrdenServicio() {
        return listRepuestoOrdenServicio;
    }

    public void setListRepuestoOrdenServicio(List<Repuesto> listRepuestoOrdenServicio) {
        this.listRepuestoOrdenServicio = listRepuestoOrdenServicio;
    }
}
