package com.backend.DocTic.Model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Usuarios")
public class UsuarioModel {
    @Id
    private ObjectId id;
    private String numDocumento;
    private String nombre;
    private String userName;
    private String correo;
    private String pSecreta;
    private String rSecreta;
    private String direccion;
    private String ciudadOrigen;
    private String depOrigen;
    private List<ObjectId> contrasenasArr; 

    public String getIdAsHexString() {
        return id != null ? id.toHexString() : null;
    }
}
