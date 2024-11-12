package com.backend.DocTic.Exception;

public class RecursoNoEncontradoException extends RuntimeException {
    public RecursoNoEncontradoException(String mensaje){
        super(mensaje);
    }
}
