package com.example.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.entity.Prestito;

/**
 * Repository per l'entita' Prestito.
 */
@Repository
public interface PrestitoRepository extends JpaRepository<Prestito, Long> {

    /** Tutti i prestiti relativi ad un determinato libro. */
    List<Prestito> findByLibroId(Long libroId);

    /** Tutti i prestiti ancora aperti (libro non ancora restituito). */
    List<Prestito> findByDataRestituzioneIsNull();
}
