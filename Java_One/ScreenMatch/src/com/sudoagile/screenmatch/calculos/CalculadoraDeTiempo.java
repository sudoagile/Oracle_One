package com.sudoagile.screenmatch.calculos;
import com.sudoagile.screenmatch.modelos.Titulo;
import com.sudoagile.screenmatch.modelos.Pelicula;
import com.sudoagile.screenmatch.modelos.Serie;

public class CalculadoraDeTiempo {
    private int tiempoTotal;

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void incluye(Titulo titulo){
        this.tiempoTotal += titulo.getDuracionEnMinutos();
    }

}
