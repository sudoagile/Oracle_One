package com.sudoagile.casadelcodigo.model;

import lombok.Data;
import java.util.List;

@Data
public class Libro {
    private String titulo;
    private List<Autor> autores;
    private Integer descargas;
    private String idioma;
}