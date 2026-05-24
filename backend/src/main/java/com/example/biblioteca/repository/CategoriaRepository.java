package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.entity.Categoria;

/**
 * Repository per l'entita' Categoria.
 * Estende JpaRepository: fornisce gia' CRUD, paginazione e ordinamento.
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
