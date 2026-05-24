package com.example.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.biblioteca.exception.ResourceNotFoundException;
import com.example.biblioteca.mapper.PrestitoMapper;
import com.example.biblioteca.model.dto.PrestitoDto;
import com.example.biblioteca.model.entity.Libro;
import com.example.biblioteca.model.entity.Prestito;
import com.example.biblioteca.repository.LibroRepository;
import com.example.biblioteca.repository.PrestitoRepository;

import lombok.RequiredArgsConstructor;

/**
 * Service per i Prestiti.
 * Risolve la relazione verso Libro a partire dall'id presente nel DTO.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class PrestitoService {

    @Autowired
    private PrestitoRepository prestitoRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private PrestitoMapper prestitoMapper;

    @Transactional(readOnly = true)
    public List<PrestitoDto> findAll() {
        return prestitoMapper.toDtoList(prestitoRepository.findAll());
    }

    @Transactional(readOnly = true)
    public PrestitoDto findById(Long id) {
        Prestito prestito = prestitoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prestito", id));
        return prestitoMapper.toDto(prestito);
    }

    public PrestitoDto create(PrestitoDto dto) {
        Prestito entity = prestitoMapper.toEntity(dto);
        entity.setLibro(recuperaLibro(dto.getLibroId()));
        return prestitoMapper.toDto(prestitoRepository.save(entity));
    }

    public PrestitoDto update(Long id, PrestitoDto dto) {
        Prestito entity = prestitoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prestito", id));
        prestitoMapper.updateEntityFromDto(dto, entity);
        entity.setLibro(recuperaLibro(dto.getLibroId()));
        return prestitoMapper.toDto(prestitoRepository.save(entity));
    }

    public void delete(Long id) {
        if (!prestitoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Prestito", id);
        }
        prestitoRepository.deleteById(id);
    }

    // --- metodi di supporto ---

    private Libro recuperaLibro(Long libroId) {
        return libroRepository.findById(libroId)
                .orElseThrow(() -> new ResourceNotFoundException("Libro", libroId));
    }

}
