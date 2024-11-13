package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;

import com.backend.DocTic.Model.ENUM.EstadoDocumento;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase DocumentoVisualizacion (12/11/2024): Modelo de datos para representar un documento visualizado, que incluye un identificador 
 * único del documento (documentoId), el nombre del documento (nombre) y su estado (estado), definido a través del enum EstadoDocumento. 
 * La anotación @JsonProperty permite que el identificador del documento se devuelva en formato hexadecimal en las respuestas JSON.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoVisualizacion {
    private ObjectId documentoId;
    private String nombre;
    private EstadoDocumento estado; 

    @JsonProperty("documentoId")
    public String getDocumentoIdAsHexString() {
        return documentoId != null ? documentoId.toHexString() : null;
    }
}

