package com.example.spotify;

import java.time.Year;

public class PodcastTodoClase {
    String titulopod;
    String descrip;

    public PodcastTodoClase(String titulopod, String descrip) {
        this.titulopod = titulopod;
        this.descrip = descrip;
    }

    public String getTitulopod() {
        return titulopod;
    }

    public void setTitulopod(String titulopod) {
        this.titulopod = titulopod;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
