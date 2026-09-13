package com.uniquindio.taller_de_bicicletas.model;

public abstract class Persona {

    protected String nombre;
    protected long telefono;
    protected String identificacion;

    public Persona(String nombre, long telefono, String identificacion){
        this.nombre = nombre;
        this.telefono = telefono;
        this.identificacion = identificacion;

    }

    public abstract void actualizarDatos(Persona nuevosDatos);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
