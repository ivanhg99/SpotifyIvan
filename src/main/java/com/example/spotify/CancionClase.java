package com.example.spotify;

public class CancionClase {
    String nombre;
    int numero_rep;
    int duracion;

    public CancionClase(String nombre, int numero_rep, int duracion) {
        this.nombre = nombre;
        this.numero_rep = numero_rep;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero_rep() {
        return numero_rep;
    }

    public void setNumero_rep(int numero_rep) {
        this.numero_rep = numero_rep;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
