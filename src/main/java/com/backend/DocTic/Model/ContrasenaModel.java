package com.backend.DocTic.Model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.backend.DocTic.Model.ENUM.EstadoContrasena;

import java.util.Date;

@Data
@Document(collection = "Contrasenas")
public class ContrasenaModel {
    @Id
    private ObjectId id;
    private String contrasena;
    private Date fecha;
    private EstadoContrasena estado;

    public String getIdAsHexString() {
        return id != null ? id.toHexString():null;
    }
}
