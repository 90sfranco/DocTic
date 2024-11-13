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

/**
 * Clase ContrasenaModel (12/11/2024): Modelo de datos para representar una contraseña en la colección "Contrasenas" de MongoDB,
 * con un identificador único (id), la contraseña almacenada (contrasena), la fecha de creación o modificación (fecha), y el 
 * estado de la contraseña (estado) definido a través del enum EstadoContrasena. La anotación @JsonProperty permite que el id 
 * se devuelva en formato hexadecimal en las respuestas JSON.
 */

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
