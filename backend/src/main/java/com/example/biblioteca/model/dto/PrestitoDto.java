package com.example.biblioteca.model.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO del Prestito.
 * In input serve solo libroId; in output viene aggiunto libroTitolo.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrestitoDto {

    private Long id;

    @NotBlank(message = "Il nome utente e' obbligatorio")
    @Size(max = 120, message = "Il nome utente non puo' superare 120 caratteri")
    private String nomeUtente;

    @NotNull(message = "La data di prestito e' obbligatoria")
    private LocalDate dataPrestito;

    private LocalDate dataRestituzione;

    @NotNull(message = "Il libro e' obbligatorio")
    private Long libroId;

    /** Campo di sola lettura, valorizzato in uscita dal mapper. */
    private String libroTitolo;

}
