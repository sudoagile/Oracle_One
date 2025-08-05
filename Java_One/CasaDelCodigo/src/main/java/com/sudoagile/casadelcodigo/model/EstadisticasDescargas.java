package com.sudoagile.casadelcodigo.model;

import lombok.Data;

@Data
public class EstadisticasDescargas {
    private Double mediaDescargas;
    private Integer maximoDescargas;
    private Integer minimoDescargas;
    private Integer totalLibros;
}