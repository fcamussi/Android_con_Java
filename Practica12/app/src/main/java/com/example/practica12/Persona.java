package com.example.practica12;

public class Persona {

    private String nombre;
    private String localidad;
    private String pais;

    public Persona(String nombre, String localidad, String pais) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
