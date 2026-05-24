package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.dto.PrestitoDto;
import com.example.biblioteca.service.PrestitoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * Controller REST per la risorsa Prestito.
 * Base URL: /api/prestiti
 */
@RestController
@RequestMapping("/api/prestiti")
@RequiredArgsConstructor
public class PrestitoController {

    @Autowired
    private PrestitoService prestitoService;

    @GetMapping
    public ResponseEntity<List<PrestitoDto>> getAll() {
        return ResponseEntity.ok(prestitoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestitoDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(prestitoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PrestitoDto> create(@Valid @RequestBody PrestitoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(prestitoService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestitoDto> update(@PathVariable Long id,
                                              @Valid @RequestBody PrestitoDto dto) {
        return ResponseEntity.ok(prestitoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        prestitoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
