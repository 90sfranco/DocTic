package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPublicacion {
    private ObjectId usuarioId;
    private String nombre;
    private String numDocumento;
    private String rol;

    @JsonProperty("usuarioId")
    public String getUsuarioIdAsHexString() {
        return usuarioId != null ? usuarioId.toHexString() : null;
    }
}

