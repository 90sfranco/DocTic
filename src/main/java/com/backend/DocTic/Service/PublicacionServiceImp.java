package com.backend.DocTic.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.DocTic.Exception.RecursoNoEncontradoException;
import com.backend.DocTic.Model.PublicacionModel;
import com.backend.DocTic.Repository.IPublicacionRepository;

@Service
public class PublicacionServiceImp implements IPublicacionService{
    @Autowired
    IPublicacionRepository repository;

    @Override
    public String insertarPublicacion(PublicacionModel publicacion){
        repository.insert(publicacion);
        return "Se insertó la publicación con éxito";
    }

    @Override
    public PublicacionModel obtenerPublicacion(ObjectId id){
        Optional<PublicacionModel> publicacionEncontrada = repository.findById(id);
        return publicacionEncontrada.orElseThrow(()-> new RecursoNoEncontradoException("No se encontró la publicación con ID "+id+" por favor verificar el ID"));
    }

    @Override
    public List<PublicacionModel> obtenerPublicaciones() {
        return repository.findAll();
    }
}
