package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.backend.DocTic.Model.ENUM.EstadoDocumento;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * Clase DocumentoModel (12/11/2024): Modelo de datos para representar un documento en la colección "Documentos" de MongoDB,
 * con un identificador único (id), descripción breve del contenido (descripcion), nombre del documento (nombre), URL de acceso 
 * (url), estado de publicación (estado), fecha de publicación (fechaPub), una lista de categorías asociadas (categoriasArr) y 
 * una lista de identificadores de autores (autoresArr). La anotación @JsonProperty permite que el id se devuelva en formato 
 * hexadecimal en las respuestas JSON.
 */

@Data
@Document(collection = "Documentos")
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoModel {
    @Id
    private ObjectId id;
    private String descripcion;
    private String nombre;
    private String url;
    private EstadoDocumento estado; 
    private Date fechaPub;
    private List<CategoriaDocumento> categoriasArr;
    private List<ObjectId> autoresArr; 

    @JsonProperty("id")
    public String getIdAsHexString() {
        return id != null ? id.toHexString() : null;
    }
}
