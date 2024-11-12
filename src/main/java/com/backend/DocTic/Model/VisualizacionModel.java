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


