package com.sudoagile.radioalura.principal;

import com.sudoagile.radioalura.modelos.Cancion;
import com.sudoagile.radioalura.modelos.MisFavoritos;
import com.sudoagile.radioalura.modelos.Podcast;

public class Principal {
    public static void main(String[] args) {
        Cancion miCancion = new Cancion();
        miCancion.setTitulo("Forever");
        miCancion.setCantante("Kiss");

        Podcast miPodcast = new Podcast();
        miPodcast.setPresentador("Gabriela Aguiar");
        miPodcast.setTitulo("Cafe.Tech");
        //Cancion
        for (int i = 0; i < 100 ; i++) {
                miCancion.meGusta();
        }
        for (int i = 0; i < 2000; i++) {
            miCancion.reproduce();
        }
        //Podcast
        for (int i = 0; i < 100 ; i++) {
            miPodcast.meGusta();
        }
        for (int i = 0; i < 8000; i++) {
            miPodcast.reproduce();
        }
        System.out.println("Total Reproducciones: "
                + miCancion.getTotalDeReproducciones());
        System.out.println("De Me gusta: "
                + miCancion.getTotalDeMeGusta());

        MisFavoritos favoritos = new MisFavoritos();
        favoritos.adicione(miPodcast);
        favoritos.adicione(miCancion);
       
    }
}