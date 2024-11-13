package com.backend.DocTic.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.DocTic.Model.VisualizacionModel;

public interface IvisualizacionRepository  extends MongoRepository<VisualizacionModel, ObjectId>{
    @Aggregation(pipeline = {
        "{ $match: { 'usuario.usuarioId': ?0, 'documento.documentoId': ?1 } }",
        "{ $limit: 1 }"
    })
    List<VisualizacionModel> findByUsuarioIdAndDocumentoId(ObjectId usuarioId, ObjectId documentoId);
    
    default boolean existsByUsuarioIdAndDocumentoId(ObjectId usuarioId, ObjectId documentoId) {
        return !findByUsuarioIdAndDocumentoId(usuarioId, documentoId).isEmpty();
    }
    
}
