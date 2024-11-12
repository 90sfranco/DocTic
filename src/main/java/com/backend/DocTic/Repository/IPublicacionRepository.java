package com.backend.DocTic.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.DocTic.Model.PublicacionModel;

@Repository

public interface IPublicacionRepository extends MongoRepository <PublicacionModel, ObjectId> {
    
}
