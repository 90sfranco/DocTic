package com.backend.DocTic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.DocTic.Model.PublicacionModel;
import com.backend.DocTic.Repository.IPublicacionRepository;

@Service
public class IPublicacionServiceImp implements IPublicacionService{
    @Autowired
    IPublicacionRepository repository;

    @Override
    public String insertarPublicacion(PublicacionModel publicacion){
        repository.insert(publicacion);
        return "Se insertó la publicación con éxito";
    }
}
