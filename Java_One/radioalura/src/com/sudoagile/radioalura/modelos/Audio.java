package com.sudoagile.radioalura.modelos;

public class Audio {
    private String titulo;
    private int totalDeReproduccioes;
    private int totalDeMeGusta;
    private int clasificacion;

    public void meGusta() {
        this.totalDeMeGusta++;

    }
    public void reproduce() {
        this.totalDeReproduccioes++;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotalDeReproduccioes() {
        return totalDeReproduccioes;
    }

    public void setTotalDeReproduccioes(int totalDeReproduccioes) {
        this.totalDeReproduccioes = totalDeReproduccioes;
    }

    public int getTotalDeMeGusta() {
        return totalDeMeGusta;
    }

    public void setTotalDeMeGusta(int totalDeMeGusta) {
        this.totalDeMeGusta = totalDeMeGusta;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }
}
