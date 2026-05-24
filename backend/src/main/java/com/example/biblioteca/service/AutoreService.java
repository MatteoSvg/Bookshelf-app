package com.example.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.biblioteca.exception.ResourceNotFoundException;
import com.example.biblioteca.mapper.AutoreMapper;
import com.example.biblioteca.model.dto.AutoreDto;
import com.example.biblioteca.model.entity.Autore;
import com.example.biblioteca.repository.AutoreRepository;

import lombok.RequiredArgsConstructor;

/**
 * Service che contiene la logica di business relativa agli Autori.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class AutoreService {

    private final AutoreRepository autoreRepository;
    private final AutoreMapper autoreMapper;

    @Transactional(readOnly = true)
    public List<AutoreDto> findAll() {
        return autoreMapper.toDtoList(autoreRepository.findAll());
    }

    @Transactional(readOnly = true)
    public AutoreDto findById(Long id) {
        Autore autore = autoreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autore", id));
        return autoreMapper.toDto(autore);
    }

    public AutoreDto create(AutoreDto dto) {
        Autore entity = autoreMapper.toEntity(dto);
        return autoreMapper.toDto(autoreRepository.save(entity));
    }

    public AutoreDto update(Long id, AutoreDto dto) {
        Autore entity = autoreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autore", id));
        autoreMapper.updateEntityFromDto(dto, entity);
        return autoreMapper.toDto(autoreRepository.save(entity));
    }

    public void delete(Long id) {
        if (!autoreRepository.existsById(id)) {
            throw new ResourceNotFoundException("Autore", id);
        }
        autoreRepository.deleteById(id);
    }

}
