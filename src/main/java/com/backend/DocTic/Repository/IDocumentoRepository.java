package com.backend.DocTic.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.DocTic.Model.DocumentoModel;

@Repository
public interface IDocumentoRepository extends MongoRepository<DocumentoModel, ObjectId>{
     @Aggregation(pipeline = {
            "{ $match: { '_id': ?0 } }",
            "{ $project: { firstAuthor: { $arrayElemAt: [ '$autoresArr', 0 ] } } }"
    })
    ObjectId findFirstAuthorById(ObjectId documentId);
} 
