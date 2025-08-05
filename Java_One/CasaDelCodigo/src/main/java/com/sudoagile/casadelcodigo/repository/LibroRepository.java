package com.sudoagile.casadelcodigo.repository;

import com.sudoagile.casadelcodigo.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTitulo(String titulo);

    @Query("SELECT l FROM Libro l ORDER BY l.descargas DESC LIMIT 10")
    List<Libro> findTopDownloadedBooks();
}
