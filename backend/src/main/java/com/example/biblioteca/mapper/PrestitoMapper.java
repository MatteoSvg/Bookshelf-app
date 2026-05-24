package com.example.biblioteca.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.biblioteca.model.dto.PrestitoDto;
import com.example.biblioteca.model.entity.Prestito;

/**
 * Mapper MapStruct per la conversione Prestito <-> PrestitoDto.
 * La relazione verso Libro viene gestita dal PrestitoService.
 */
@Mapper(componentModel = "spring")
public interface PrestitoMapper {

    @Mapping(source = "libro.id", target = "libroId")
    @Mapping(source = "libro.titolo", target = "libroTitolo")
    PrestitoDto toDto(Prestito entity);

    List<PrestitoDto> toDtoList(List<Prestito> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "libro", ignore = true)
    Prestito toEntity(PrestitoDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "libro", ignore = true)
    void updateEntityFromDto(PrestitoDto dto, @MappingTarget Prestito entity);

}
