package com.aluracursos.screenmatch.model;

import lombok.Data;

@Data
public class Serie {
    private String titulo;
    private Integer totalTemporadas;
    private Double evaluacion;
    private String poster;
    private Categoria genero;
    private String actores;
    private String sinopsis;

    public Serie(DatosSerie datosSerie) {
        this.titulo = datosSerie.titulo();
        this.totalTemporadas = datosSerie.totalTemporadas();
        try {
            this.evaluacion = Double.valueOf(datosSerie.evaluacion());
        } catch (NumberFormatException e) {
            this.evaluacion = 0.0;
        }
        this.poster = datosSerie.poster();

        // --- ESTA ES LA PARTE IMPORTANTE ---
        // Intentamos convertir el género, pero si falla, no detenemos el programa
        try {
            // Obtenemos solo el primer género de la lista (ej: "Action, Thriller" -> "Action")
            this.genero = Categoria.fromString(datosSerie.genero().split(",")[0].trim());
        } catch (IllegalArgumentException | NullPointerException e) {
            // Si el género es nulo o no está en nuestro enum, asignamos NO_DEFINIDO
            this.genero = Categoria.NO_DEFINIDO;
        }

        this.actores = datosSerie.actores();
        this.sinopsis = datosSerie.sinopsis();
    }

    @Override
    public String toString() {
        return "titulo='" + titulo + '\'' +
               ", totalTemporadas=" + totalTemporadas +
               ", evaluacion=" + evaluacion +
               ", poster='" + poster + '\'' +
               ", genero=" + genero +
               ", actores='" + actores + '\'' +
               ", sinopsis='" + sinopsis + '\'';
    }
}