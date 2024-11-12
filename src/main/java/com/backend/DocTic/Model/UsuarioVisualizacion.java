package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;

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
