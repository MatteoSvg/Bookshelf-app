package com.example.biblioteca.mapper;

import com.example.biblioteca.model.dto.AutoreDto;
import com.example.biblioteca.model.entity.Autore;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-24T16:26:08+0200",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class AutoreMapperImpl implements AutoreMapper {

    @Override
    public AutoreDto toDto(Autore entity) {
        if ( entity == null ) {
            return null;
        }

        AutoreDto.AutoreDtoBuilder autoreDto = AutoreDto.builder();

        autoreDto.cognome( entity.getCognome() );
        autoreDto.id( entity.getId() );
        autoreDto.nazionalita( entity.getNazionalita() );
        autoreDto.nome( entity.getNome() );

        return autoreDto.build();
    }

    @Override
    public List<AutoreDto> toDtoList(List<Autore> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AutoreDto> list = new ArrayList<AutoreDto>( entities.size() );
        for ( Autore autore : entities ) {
            list.add( toDto( autore ) );
        }

        return list;
    }

    @Override
    public Autore toEntity(AutoreDto dto) {
        if ( dto == null ) {
            return null;
        }

        Autore.AutoreBuilder autore = Autore.builder();

        autore.cognome( dto.getCognome() );
        autore.nazionalita( dto.getNazionalita() );
        autore.nome( dto.getNome() );

        return autore.build();
    }

    @Override
    public void updateEntityFromDto(AutoreDto dto, Autore entity) {
        if ( dto == null ) {
            return;
        }

        entity.setCognome( dto.getCognome() );
        entity.setNazionalita( dto.getNazionalita() );
        entity.setNome( dto.getNome() );
    }
}
