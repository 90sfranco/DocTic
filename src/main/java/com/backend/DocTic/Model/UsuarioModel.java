package com.backend.DocTic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Clase UsuarioModel (12/11/2024): Modelo de datos para representar un usuario en la colección "Usuarios" de MongoDB, 
 * que incluye un identificador único (id), número de documento (numDocumento), nombre completo (nombre), nombre de usuario 
 * (userName), correo electrónico (correo), pregunta y respuesta secreta para recuperación de cuenta (pSecreta y rSecreta), 
 * dirección (direccion), ciudad de origen (ciudadOrigen), departamento de origen (depOrigen), y una lista de identificadores 
 * de contraseñas asociadas (contrasenasArr). La anotación @JsonProperty permite que el id se devuelva en formato hexadecimal 
 * en las respuestas JSON.
 */

@Data
@Document(collection = "Usuarios")
@AllArgsConstructor
@NoArgsConstructor

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

    
    @JsonProperty("id")
    public String getIdAsHexString() {
        return id != null ? id.toHexString() : null;
    }
}
