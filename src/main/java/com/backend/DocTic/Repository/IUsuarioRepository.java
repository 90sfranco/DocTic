package com.backend.DocTic.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.DocTic.Model.UsuarioModel;

@Repository
public interface IUsuarioRepository extends MongoRepository<UsuarioModel, ObjectId>{
    
}
