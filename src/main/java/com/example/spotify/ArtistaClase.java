package com.example.spotify;

public class ArtistaClase {
    String nombreal;
    int anio;

    public ArtistaClase(String nombreal, int anio) {
        this.nombreal = nombreal;
        this.anio = anio;
    }

    public String getNombreal() {
        return nombreal;
    }

    public void setNombreal(String nombreal) {
        this.nombreal = nombreal;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
