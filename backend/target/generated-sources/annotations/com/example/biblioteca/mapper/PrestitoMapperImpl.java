package com.example.biblioteca.mapper;

import com.example.biblioteca.model.dto.PrestitoDto;
import com.example.biblioteca.model.entity.Libro;
import com.example.biblioteca.model.entity.Prestito;
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
public class PrestitoMapperImpl implements PrestitoMapper {

    @Override
    public PrestitoDto toDto(Prestito entity) {
        if ( entity == null ) {
            return null;
        }

        PrestitoDto.PrestitoDtoBuilder prestitoDto = PrestitoDto.builder();

        prestitoDto.libroId( entityLibroId( entity ) );
        prestitoDto.libroTitolo( entityLibroTitolo( entity ) );
        prestitoDto.dataPrestito( entity.getDataPrestito() );
        prestitoDto.dataRestituzione( entity.getDataRestituzione() );
        prestitoDto.id( entity.getId() );
        prestitoDto.nomeUtente( entity.getNomeUtente() );

        return prestitoDto.build();
    }

    @Override
    public List<PrestitoDto> toDtoList(List<Prestito> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PrestitoDto> list = new ArrayList<PrestitoDto>( entities.size() );
        for ( Prestito prestito : entities ) {
            list.add( toDto( prestito ) );
        }

        return list;
    }

    @Override
    public Prestito toEntity(PrestitoDto dto) {
        if ( dto == null ) {
            return null;
        }

        Prestito.PrestitoBuilder prestito = Prestito.builder();

        prestito.dataPrestito( dto.getDataPrestito() );
        prestito.dataRestituzione( dto.getDataRestituzione() );
        prestito.nomeUtente( dto.getNomeUtente() );

        return prestito.build();
    }

    @Override
    public void updateEntityFromDto(PrestitoDto dto, Prestito entity) {
        if ( dto == null ) {
            return;
        }

        entity.setDataPrestito( dto.getDataPrestito() );
        entity.setDataRestituzione( dto.getDataRestituzione() );
        entity.setNomeUtente( dto.getNomeUtente() );
    }

    private Long entityLibroId(Prestito prestito) {
        Libro libro = prestito.getLibro();
        if ( libro == null ) {
            return null;
        }
        return libro.getId();
    }

    private String entityLibroTitolo(Prestito prestito) {
        Libro libro = prestito.getLibro();
        if ( libro == null ) {
            return null;
        }
        return libro.getTitolo();
    }
}
