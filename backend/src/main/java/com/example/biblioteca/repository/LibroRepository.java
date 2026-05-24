package com.example.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.entity.Libro;

/**
 * Repository per l'entita' Libro.
 * Include alcune query derivate di esempio.
 */
@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    /** Tutti i libri di una determinata categoria. */
    List<Libro> findByCategoriaId(Long categoriaId);

    /** Tutti i libri di un determinato autore. */
    List<Libro> findByAutoreId(Long autoreId);

    /** Tutti i libri attualmente disponibili. */
    List<Libro> findByDisponibileTrue();
}
