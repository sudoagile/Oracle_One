package com.sudoagile.screenmatch.principal;

import com.sudoagile.screenmatch.modelos.Pelicula;
import com.sudoagile.screenmatch.modelos.Serie;
import com.sudoagile.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalConListas {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("Avatar", 2023);
        otraPelicula.evalua(6);
        var peliculaDeBruno = new Pelicula("El señor de los anillos", 2001);
        peliculaDeBruno.evalua(10);
        Serie lost = new Serie("Lost", 2000);

        Titulo favorito = new Pelicula("Ejemplo Favorito", 2024);
        Titulo otro = new Serie("Otra Serie", 2022);
        Titulo serie = new Serie("Ejemplo Serie", 2023);


        Pelicula p1 = miPelicula;

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaDeBruno);
        lista.add(lost);

        for (Titulo item : lista) {
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
                System.out.println(pelicula.getClasificacion());
            }
        }

        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Penelope Cruz");
        listaDeArtistas.add("Antonio Barrier");
        listaDeArtistas.add("Ricardo Darin");

        System.out.println("Lista de Artistas no ordenada: "+listaDeArtistas);

        Collections.sort(listaDeArtistas);
        System.out.println("Lista de Artistas ordenada: "+listaDeArtistas);

        Collections.sort(lista);
        System.out.println("Lista de Títulos ordenada: "+0+lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha: "+lista);

        ArrayList<Titulo> lista2 = new ArrayList<>();
        lista2.add(favorito);
        lista2.add(otro);
        lista2.add(serie);

        Collections.sort(lista2);
        System.out.println(lista2);

    }
}
