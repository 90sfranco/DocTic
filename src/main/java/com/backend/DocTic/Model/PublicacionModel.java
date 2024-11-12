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
