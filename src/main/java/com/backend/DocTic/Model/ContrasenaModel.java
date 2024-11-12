package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.backend.DocTic.Model.ENUM.EstadoContrasena;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@Data
@Document(collection = "Contrasenas")
@AllArgsConstructor
@NoArgsConstructor

public class ContrasenaModel {
    @Id
    private ObjectId id;
    private String contrasena;
    private Date fecha;
    private EstadoContrasena estado;

    
    @JsonProperty("id")
    public String getIdAsHexString() {
        return id != null ? id.toHexString():null;
    }
}
