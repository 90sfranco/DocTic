package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase UsuarioVisualizacion (12/11/2024): Modelo de datos para representar un usuario asociado a una visualización,
 * que incluye un identificador único del usuario (usuarioId), el nombre del usuario (nombre) y su número de documento 
 * (numDocumento). La anotación @JsonProperty permite que el identificador del usuario se devuelva en formato hexadecimal 
 * en las respuestas JSON.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioVisualizacion {
    private ObjectId usuarioId;
    private String nombre;
    private String numDocumento;

    @JsonProperty("usuarioId")
    public String getUsuarioIdAsHexString() {
        return usuarioId != null ? usuarioId.toHexString() : null;
    }
}
