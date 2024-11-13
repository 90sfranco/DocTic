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
 * Clase VisualizacionModel (12/11/2024): Modelo de datos para representar una visualización de un documento en la colección "Visualizaciones" 
 * de MongoDB, que incluye un identificador único (id), fecha de visualización (fecha), hora de visualización (hora), el usuario que visualizó 
 * el documento (usuario) y el documento visualizado (documento). La anotación @JsonProperty permite que el id se devuelva en formato hexadecimal 
 * en las respuestas JSON.
 */

@Data
@Document(collection = "Visualizaciones")
@AllArgsConstructor
@NoArgsConstructor
public class VisualizacionModel {
    @Id
    private ObjectId id;
    private Date fecha;
    private String hora;
    private UsuarioVisualizacion usuario;
    private DocumentoVisualizacion documento;

    @JsonProperty("id")
    public String getIdAsHexString() {
        return id != null ? id.toHexString() : null;
    }
}


