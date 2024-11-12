package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.backend.DocTic.Model.ENUM.RolUsuarioPublicacion;
import com.fasterxml.jackson.annotation.JsonProperty;

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

