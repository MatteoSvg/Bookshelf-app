package com.example.biblioteca.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.biblioteca.model.dto.LibroDto;
import com.example.biblioteca.model.entity.Libro;

/**
 * Mapper MapStruct per la conversione Libro <-> LibroDto.
 *
 * In uscita (toDto) le relazioni vengono "appiattite" su id + descrizione.
 * In entrata (toEntity / update) le relazioni vengono ignorate dal mapper:
 * sara' il LibroService a recuperare e collegare Autore e Categoria.
 */
@Mapper(componentModel = "spring")
public interface LibroMapper {

    @Mapping(source = "autore.id", target = "autoreId")
    @Mapping(target = "autoreNomeCompleto",
            expression = "java(entity.getAutore() != null "
                    + "? entity.getAutore().getNome() + \" \" + entity.getAutore().getCognome() "
                    + ": null)")
    @Mapping(source = "categoria.id", target = "categoriaId")
    @Mapping(source = "categoria.nome", target = "categoriaNome")
    LibroDto toDto(Libro entity);

    List<LibroDto> toDtoList(List<Libro> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "autore", ignore = true)
    @Mapping(target = "categoria", ignore = true)
    Libro toEntity(LibroDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "autore", ignore = true)
    @Mapping(target = "categoria", ignore = true)
    void updateEntityFromDto(LibroDto dto, @MappingTarget Libro entity);

}
