package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase CategoriaModel (12/11/2024): Modelo de datos para representar una categoría en la colección "Categorias" de MongoDB,
 * que incluye un identificador único (id), el nombre de la categoría (nombre) y un identificador opcional para una categoría 
 * padre (catPadreId) que permite establecer relaciones jerárquicas. La anotación @JsonProperty permite devolver los identificadores 
 * en formato hexadecimal en las respuestas JSON.
 */


@Data
@Document(collection = "Categorias")
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaModel {
    @Id
    private ObjectId id;
    private String nombre;
    private ObjectId catPadreId; // ID de la categoría padre, si existe

    @JsonProperty("id")
    public String getIdAsHexString() {
        return id != null ? id.toHexString() : null;
    }
    @JsonProperty("catPadreId")
    public String getCatPadreIdAsHexString() {
        return catPadreId != null ? catPadreId.toHexString() : null;
    }
}
