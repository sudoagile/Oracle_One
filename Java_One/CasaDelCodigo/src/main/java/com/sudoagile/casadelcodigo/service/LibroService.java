package com.sudoagile.casadelcodigo.service;

import com.sudoagile.casadelcodigo.model.Libro;
import com.sudoagile.casadelcodigo.model.EstadisticasDescargas;
import java.util.List;

public interface LibroService {
    List<Libro> obtenerTodosLosLibros();
    List<Libro> obtenerTopLibros();
    List<Libro> buscarLibrosPorTitulo(String titulo);
    EstadisticasDescargas calcularEstadisticasDescargas();
}


