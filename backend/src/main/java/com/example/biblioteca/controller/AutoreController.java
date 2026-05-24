package com.example.biblioteca.controller;

import java.util.List;

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

import com.example.biblioteca.model.dto.AutoreDto;
import com.example.biblioteca.service.AutoreService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * Controller REST per la risorsa Autore.
 * Base URL: /api/autori
 */
@RestController
@RequestMapping("/api/autori")
@RequiredArgsConstructor
public class AutoreController {

    private final AutoreService autoreService;

    @GetMapping
    public ResponseEntity<List<AutoreDto>> getAll() {
        return ResponseEntity.ok(autoreService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoreDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(autoreService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AutoreDto> create(@Valid @RequestBody AutoreDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(autoreService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutoreDto> update(@PathVariable Long id,
                                            @Valid @RequestBody AutoreDto dto) {
        return ResponseEntity.ok(autoreService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        autoreService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
