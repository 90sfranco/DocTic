package com.backend.DocTic.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.DocTic.Model.ComentarioModel;

@Repository

public interface IComentarioRepository extends MongoRepository<ComentarioModel, ObjectId> {

}

