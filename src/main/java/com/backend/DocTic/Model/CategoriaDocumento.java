package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDocumento {
    private ObjectId categoriaId;
    private String nombre;

    @JsonProperty("categoriaId")
    public String getCategoriaIdAsHexString() {
        return categoriaId != null ? categoriaId.toHexString() : null;
    }
}
