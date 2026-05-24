package com.example.biblioteca.mapper;

import com.example.biblioteca.model.dto.LibroDto;
import com.example.biblioteca.model.entity.Autore;
import com.example.biblioteca.model.entity.Categoria;
import com.example.biblioteca.model.entity.Libro;
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
public class LibroMapperImpl implements LibroMapper {

    @Override
    public LibroDto toDto(Libro entity) {
        if ( entity == null ) {
            return null;
        }

        LibroDto.LibroDtoBuilder libroDto = LibroDto.builder();

        libroDto.autoreId( entityAutoreId( entity ) );
        libroDto.categoriaId( entityCategoriaId( entity ) );
        libroDto.categoriaNome( entityCategoriaNome( entity ) );
        libroDto.annoPubblicazione( entity.getAnnoPubblicazione() );
        libroDto.disponibile( entity.getDisponibile() );
        libroDto.id( entity.getId() );
        libroDto.isbn( entity.getIsbn() );
        libroDto.titolo( entity.getTitolo() );

        libroDto.autoreNomeCompleto( entity.getAutore() != null ? entity.getAutore().getNome() + " " + entity.getAutore().getCognome() : null );

        return libroDto.build();
    }

    @Override
    public List<LibroDto> toDtoList(List<Libro> entities) {
        if ( entities == null ) {
            return null;
        }

        List<LibroDto> list = new ArrayList<LibroDto>( entities.size() );
        for ( Libro libro : entities ) {
            list.add( toDto( libro ) );
        }

        return list;
    }

    @Override
    public Libro toEntity(LibroDto dto) {
        if ( dto == null ) {
            return null;
        }

        Libro.LibroBuilder libro = Libro.builder();

        libro.annoPubblicazione( dto.getAnnoPubblicazione() );
        libro.disponibile( dto.getDisponibile() );
        libro.isbn( dto.getIsbn() );
        libro.titolo( dto.getTitolo() );

        return libro.build();
    }

    @Override
    public void updateEntityFromDto(LibroDto dto, Libro entity) {
        if ( dto == null ) {
            return;
        }

        entity.setAnnoPubblicazione( dto.getAnnoPubblicazione() );
        entity.setDisponibile( dto.getDisponibile() );
        entity.setIsbn( dto.getIsbn() );
        entity.setTitolo( dto.getTitolo() );
    }

    private Long entityAutoreId(Libro libro) {
        Autore autore = libro.getAutore();
        if ( autore == null ) {
            return null;
        }
        return autore.getId();
    }

    private Long entityCategoriaId(Libro libro) {
        Categoria categoria = libro.getCategoria();
        if ( categoria == null ) {
            return null;
        }
        return categoria.getId();
    }

    private String entityCategoriaNome(Libro libro) {
        Categoria categoria = libro.getCategoria();
        if ( categoria == null ) {
            return null;
        }
        return categoria.getNome();
    }
}
