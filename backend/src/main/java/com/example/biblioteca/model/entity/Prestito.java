package com.example.biblioteca.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entita' Prestito: rappresenta il prestito di un Libro ad un utente.
 * La data di restituzione e' nulla finche' il libro non viene reso.
 */
@Entity
@Table(name = "prestito")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_utente", nullable = false, length = 120)
    private String nomeUtente;

    @Column(name = "data_prestito", nullable = false)
    private LocalDate dataPrestito;

    @Column(name = "data_restituzione")
    private LocalDate dataRestituzione;

    /** Relazione N:1 verso Libro. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

}
