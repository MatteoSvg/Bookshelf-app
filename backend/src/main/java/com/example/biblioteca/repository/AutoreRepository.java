package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.entity.Autore;

/**
 * Repository per l'entita' Autore.
 */
@Repository
public interface AutoreRepository extends JpaRepository<Autore, Long> {
}
