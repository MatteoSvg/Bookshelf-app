package com.example.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.biblioteca.exception.ResourceNotFoundException;
import com.example.biblioteca.mapper.CategoriaMapper;
import com.example.biblioteca.model.dto.CategoriaDto;
import com.example.biblioteca.model.entity.Categoria;
import com.example.biblioteca.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

/**
 * Service che contiene la logica di business relativa alle Categorie.
 * Espone solo DTO verso il controller.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Transactional(readOnly = true)
    public List<CategoriaDto> findAll() {
        return categoriaMapper.toDtoList(categoriaRepository.findAll());
    }

    @Transactional(readOnly = true)
    public CategoriaDto findById(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria", id));
        return categoriaMapper.toDto(categoria);
    }

    public CategoriaDto create(CategoriaDto dto) {
        Categoria entity = categoriaMapper.toEntity(dto);
        return categoriaMapper.toDto(categoriaRepository.save(entity));
    }

    public CategoriaDto update(Long id, CategoriaDto dto) {
        Categoria entity = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria", id));
        categoriaMapper.updateEntityFromDto(dto, entity);
        return categoriaMapper.toDto(categoriaRepository.save(entity));
    }

    public void delete(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Categoria", id);
        }
        categoriaRepository.deleteById(id);
    }

}
