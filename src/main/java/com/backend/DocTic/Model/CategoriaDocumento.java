package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase CategoriaDocumento (12/11/2024): Modelo de datos para representar una categoría asociada a un documento, 
 * que incluye un identificador único de la categoría (categoriaId) y el nombre de la categoría (nombre). La anotación 
 * @JsonProperty permite que el identificador de la categoría se devuelva en formato hexadecimal en las respuestas JSON.
 */

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
