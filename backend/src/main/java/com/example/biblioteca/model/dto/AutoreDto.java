package com.example.biblioteca.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO dell'Autore, usato negli scambi con il frontend.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutoreDto {

    private Long id;

    @NotBlank(message = "Il nome dell'autore e' obbligatorio")
    @Size(max = 80, message = "Il nome non puo' superare 80 caratteri")
    private String nome;

    @NotBlank(message = "Il cognome dell'autore e' obbligatorio")
    @Size(max = 80, message = "Il cognome non puo' superare 80 caratteri")
    private String cognome;

    @Size(max = 60, message = "La nazionalita' non puo' superare 60 caratteri")
    private String nazionalita;

}
