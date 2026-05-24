package com.example.biblioteca.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO del Libro.
 * Le relazioni sono "appiattite": in input servono solo gli id
 * (autoreId, categoriaId), in output vengono aggiunti i campi descrittivi.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibroDto {

    private Long id;

    @NotBlank(message = "Il titolo e' obbligatorio")
    @Size(max = 150, message = "Il titolo non puo' superare 150 caratteri")
    private String titolo;

    @Size(max = 20, message = "L'ISBN non puo' superare 20 caratteri")
    private String isbn;

    private Integer annoPubblicazione;

    @NotNull(message = "Il campo disponibile e' obbligatorio")
    private Boolean disponibile;

    @NotNull(message = "L'autore e' obbligatorio")
    private Long autoreId;

    /** Campo di sola lettura, valorizzato in uscita dal mapper. */
    private String autoreNomeCompleto;

    @NotNull(message = "La categoria e' obbligatoria")
    private Long categoriaId;

    /** Campo di sola lettura, valorizzato in uscita dal mapper. */
    private String categoriaNome;

}
