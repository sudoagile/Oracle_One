package com.sudoagile.screenmatch.modelos;

import com.sudoagile.screenmatch.calculos.Clasificable;

public class Pelicula extends Titulo implements Clasificable {
    private String director;

    public Pelicula(String nombre, int fechaDeLanzamiento, String director) {
        super(nombre, fechaDeLanzamiento);
        this.director = director;
    }



    public Pelicula(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);

    }



    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int) calculaMediaEvaluaciones() / 2;
    }

    @Override
    public String toString() {
        return "Película: " + this.getNombre() + " (" + this.getFechaDeLanzamiento()+")";

    }
}
