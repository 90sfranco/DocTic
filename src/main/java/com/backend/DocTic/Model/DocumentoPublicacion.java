package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoPublicacion {
    private ObjectId documentoId;
    private String nombre;
    private String estado; 

    @JsonProperty("documentoId")
    public String getDocumentoIdAsHexString() {
        return documentoId != null ? documentoId.toHexString() : null;
    }
}

