package com.aluracursos.screenmatch.model;

public enum Categoria {
    ACCION("Action"),
    ROMANCE("Romance"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    CRIMEN("Crime"),
    NO_DEFINIDO("N/A"); // Añadimos una categoría para casos desconocidos

    private final String categoriaOmdb;

    Categoria(String categoriaOmdb) {
        this.categoriaOmdb = categoriaOmdb;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            // Comparamos el texto de la API con nuestras categorías
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        // Si no se encuentra, lanzamos la excepción
        throw new IllegalArgumentException("Ninguna categoría encontrada para el texto: " + text);
    }
}