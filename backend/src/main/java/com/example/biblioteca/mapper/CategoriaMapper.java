package com.example.biblioteca.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.biblioteca.model.dto.CategoriaDto;
import com.example.biblioteca.model.entity.Categoria;

/**
 * Mapper MapStruct per la conversione Categoria <-> CategoriaDto.
 * componentModel = "spring" rende il mapper un bean iniettabile.
 */
@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaDto toDto(Categoria entity);

    List<CategoriaDto> toDtoList(List<Categoria> entities);

    @Mapping(target = "id", ignore = true)
    Categoria toEntity(CategoriaDto dto);

    /** Aggiorna un'entita' esistente con i valori del DTO (id escluso). */
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(CategoriaDto dto, @MappingTarget Categoria entity);

}
