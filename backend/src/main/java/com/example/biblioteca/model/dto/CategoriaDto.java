package com.example.biblioteca.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO della Categoria, usato negli scambi con il frontend.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaDto {

    private Long id;

    @NotBlank(message = "Il nome della categoria e' obbligatorio")
    @Size(max = 80, message = "Il nome non puo' superare 80 caratteri")
    private String nome;

    @Size(max = 255, message = "La descrizione non puo' superare 255 caratteri")
    private String descrizione;

}
