package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Clase ComentarioModel (12/11/2024): Modelo de datos para representar un comentario en la colección "Comentarios" de MongoDB, 
 * incluyendo un identificador único (id), la fecha de creación (fecha), el texto del comentario (comentario), un identificador 
 * opcional para el comentario padre (comPadreId), el identificador del usuario que realizó el comentario (usuarioId), y un 
 * identificador del documento relacionado (documento). La anotación @JsonProperty permite que el id se devuelva en formato 
 * hexadecimal en las respuestas JSON.
 */


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
    private ObjectId documento; 

    @JsonProperty("id")
    public String getIdAsHexString() {
        return id != null ? id.toHexString():null;
    }
}