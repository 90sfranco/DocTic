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
