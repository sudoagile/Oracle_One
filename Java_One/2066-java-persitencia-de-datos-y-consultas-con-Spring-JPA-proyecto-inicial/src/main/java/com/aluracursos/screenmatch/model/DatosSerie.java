package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons") Integer totalTemporadas,
        @JsonAlias("imdbRating") String evaluacion,
        @JsonAlias("Poster") String poster,
        @JsonAlias("Genre") String genero,
        @JsonAlias("Actors") String actores,
        @JsonAlias("Plot") String sinopsis
) {
    @Override
    public String toString() {
        return "DatosSerie{" +
                "titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", evaluacion='" + evaluacion + '\'' +
                ", genero='" + genero + '\'' +
                ", actores='" + actores + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                '}';
    }
}