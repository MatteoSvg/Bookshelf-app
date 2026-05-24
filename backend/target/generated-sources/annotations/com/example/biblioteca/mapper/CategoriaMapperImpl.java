package com.example.biblioteca.mapper;

import com.example.biblioteca.model.dto.CategoriaDto;
import com.example.biblioteca.model.entity.Categoria;
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
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaDto toDto(Categoria entity) {
        if ( entity == null ) {
            return null;
        }

        CategoriaDto.CategoriaDtoBuilder categoriaDto = CategoriaDto.builder();

        categoriaDto.descrizione( entity.getDescrizione() );
        categoriaDto.id( entity.getId() );
        categoriaDto.nome( entity.getNome() );

        return categoriaDto.build();
    }

    @Override
    public List<CategoriaDto> toDtoList(List<Categoria> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CategoriaDto> list = new ArrayList<CategoriaDto>( entities.size() );
        for ( Categoria categoria : entities ) {
            list.add( toDto( categoria ) );
        }

        return list;
    }

    @Override
    public Categoria toEntity(CategoriaDto dto) {
        if ( dto == null ) {
            return null;
        }

        Categoria.CategoriaBuilder categoria = Categoria.builder();

        categoria.descrizione( dto.getDescrizione() );
        categoria.nome( dto.getNome() );

        return categoria.build();
    }

    @Override
    public void updateEntityFromDto(CategoriaDto dto, Categoria entity) {
        if ( dto == null ) {
            return;
        }

        entity.setDescrizione( dto.getDescrizione() );
        entity.setNome( dto.getNome() );
    }
}
