package com.example.biblioteca.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entita' Autore: rappresenta l'autore di uno o piu' libri.
 */
@Entity
@Table(name = "autore")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Autore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 80)
    private String nome;

    @Column(name = "cognome", nullable = false, length = 80)
    private String cognome;

    @Column(name = "nazionalita", length = 60)
    private String nazionalita;

}
