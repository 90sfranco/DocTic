package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@Data
@Document(collection = "Comentarios")
@AllArgsConstructor
@NoArgsConstructor

public class ComentarioModel {
    @Id
    private ObjectId id;
    private Date fecha;
    private String comentario;
    private ObjectId comPadreId;
    private ObjectId usuarioId; 
    private ObjectId documentoId; 

    @JsonProperty("id")
    public String getIdAsHexString() {
        return id != null ? id.toHexString():null;
    }
}