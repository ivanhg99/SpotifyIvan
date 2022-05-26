package com.example.spotify;

import java.util.Date;

public class PodcastClase {
    String tit;
    String des;
    Date fecha;

    public PodcastClase(String tit, String des, Date fecha) {
        this.tit = tit;
        this.des = des;
        this.fecha = fecha;
    }

    public String getTit() {
        return tit;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
