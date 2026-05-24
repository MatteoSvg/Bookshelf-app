package com.example.biblioteca.exception;

/**
 * Eccezione sollevata quando una risorsa richiesta non esiste.
 * Viene tradotta in HTTP 404 dal GlobalExceptionHandler.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String risorsa, Long id) {
        super(risorsa + " con id " + id + " non trovato/a");
    }

}
