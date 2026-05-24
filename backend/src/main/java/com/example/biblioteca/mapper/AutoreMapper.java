package com.example.biblioteca.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.biblioteca.model.dto.AutoreDto;
import com.example.biblioteca.model.entity.Autore;

/**
 * Mapper MapStruct per la conversione Autore <-> AutoreDto.
 */
@Mapper(componentModel = "spring")
public interface AutoreMapper {

    AutoreDto toDto(Autore entity);

    List<AutoreDto> toDtoList(List<Autore> entities);

    @Mapping(target = "id", ignore = true)
    Autore toEntity(AutoreDto dto);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(AutoreDto dto, @MappingTarget Autore entity);

}
