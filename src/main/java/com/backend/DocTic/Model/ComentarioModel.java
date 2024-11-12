package com.backend.DocTic.Model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document(collection = "Comentarios")
public class ComentarioModel {
    @Id
    private ObjectId id;
    private Date fecha;
    private String comentario;
    private ObjectId comPadreId;
    private ObjectId usuarioId; 
    private ObjectId documento; 

    public String getIdAsHexString() {
        return id != null ? id.toHexString():null;
    }
}