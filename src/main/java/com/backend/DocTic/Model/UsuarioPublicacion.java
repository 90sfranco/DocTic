package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.backend.DocTic.Model.ENUM.RolUsuarioPublicacion;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Clase UsuarioPublicacion (12/11/2024): Modelo de datos para representar un usuario asociado a una publicación en MongoDB,
 * que incluye un identificador único del usuario (usuarioId), el nombre del usuario (nombre), su número de documento 
 * (numDocumento), y el rol del usuario en la publicación (rol), definido a través del enum RolUsuarioPublicacion. 
 * La anotación @JsonProperty permite que el identificador del usuario se devuelva en formato hexadecimal en las respuestas JSON.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class UsuarioPublicacion {
    private ObjectId usuarioId;
    private String nombre;
    private String numDocumento;
    private RolUsuarioPublicacion rol;

    @JsonProperty("usuarioId")
    public String getUsuarioIdAsHexString() {
        return usuarioId != null ? usuarioId.toHexString() : null;
    }
}

