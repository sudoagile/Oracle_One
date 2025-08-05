package com.sudoagile.casadelcodigo.service;

import com.sudoagile.casadelcodigo.model.Libro;
import com.sudoagile.casadelcodigo.model.EstadisticasDescargas;
import com.sudoagile.casadelcodigo.repository.LibroRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {
    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> obtenerLibros() {
        return libroRepository.findAll();
    }

    @Override
    public List<Libro> obtenerTopLibros() {
        return libroRepository.findTop10ByOrderByDescargasDesc();
    }

    @Override
    public List<Libro> buscarLibros(String titulo) {
        return libroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public EstadisticasDescargas obtenerEstadisticas() {
        long totalDescargas = libroRepository.sumTotalDescargas();
        return new EstadisticasDescargas(totalDescargas);
    }
}