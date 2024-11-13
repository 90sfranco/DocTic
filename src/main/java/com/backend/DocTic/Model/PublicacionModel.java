package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Clase PublicacionModel (12/11/2024): Modelo de datos para representar una publicación en la colección "Publicaciones" de MongoDB,
 * que incluye un identificador único (id), fecha de publicación (fechaPub), el usuario que realizó la publicación (usuario) y el
 * documento asociado a la publicación (documento). La anotación @TypeAlias permite identificar la clase como "Publicacion" en MongoDB,
 * mientras que @JsonProperty permite que el id se devuelva en formato hexadecimal en las respuestas JSON.
 */

@Data
@Document("Publicaciones")
@TypeAlias("Publicacion")
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionModel {
    @Id
    private ObjectId id;
    private Date fechaPub;
    private UsuarioPublicacion usuario;
    private DocumentoPublicacion documento;

    @JsonProperty("id")
    public String getIdAsHexString() {
        return id != null ? id.toHexString() : null;
    }
}
