package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.backend.DocTic.Model.ENUM.EstadoDocumento;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class DocumentoPublicacion {
    private ObjectId documentoId;
    private String nombre;
    private EstadoDocumento estado; 

    @JsonProperty("documentoId")
    public String getDocumentoIdAsHexString() {
        return documentoId != null ? documentoId.toHexString() : null;
    }
}

