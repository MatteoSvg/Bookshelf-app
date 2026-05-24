package com.example.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.biblioteca.exception.ResourceNotFoundException;
import com.example.biblioteca.mapper.LibroMapper;
import com.example.biblioteca.model.dto.LibroDto;
import com.example.biblioteca.model.entity.Autore;
import com.example.biblioteca.model.entity.Categoria;
import com.example.biblioteca.model.entity.Libro;
import com.example.biblioteca.repository.AutoreRepository;
import com.example.biblioteca.repository.CategoriaRepository;
import com.example.biblioteca.repository.LibroRepository;

import lombok.RequiredArgsConstructor;

/**
 * Service per i Libri.
 * Si occupa anche di risolvere le relazioni verso Autore e Categoria
 * a partire dagli id contenuti nel DTO.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LibroMapper libroMapper;

    @Transactional(readOnly = true)
    public List<LibroDto> findAll() {
        return libroMapper.toDtoList(libroRepository.findAll());
    }

    @Transactional(readOnly = true)
    public LibroDto findById(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro", id));
        return libroMapper.toDto(libro);
    }

    public LibroDto create(LibroDto dto) {
        Libro entity = libroMapper.toEntity(dto);
        entity.setAutore(recuperaAutore(dto.getAutoreId()));
        entity.setCategoria(recuperaCategoria(dto.getCategoriaId()));
        return libroMapper.toDto(libroRepository.save(entity));
    }

    public LibroDto update(Long id, LibroDto dto) {
        Libro entity = libroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro", id));
        libroMapper.updateEntityFromDto(dto, entity);
        entity.setAutore(recuperaAutore(dto.getAutoreId()));
        entity.setCategoria(recuperaCategoria(dto.getCategoriaId()));
        return libroMapper.toDto(libroRepository.save(entity));
    }

    public void delete(Long id) {
        if (!libroRepository.existsById(id)) {
            throw new ResourceNotFoundException("Libro", id);
        }
        libroRepository.deleteById(id);
    }

    // --- metodi di supporto ---

    private Autore recuperaAutore(Long autoreId) {
        return autoreRepository.findById(autoreId)
                .orElseThrow(() -> new ResourceNotFoundException("Autore", autoreId));
    }

    private Categoria recuperaCategoria(Long categoriaId) {
        return categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria", categoriaId));
    }

}
