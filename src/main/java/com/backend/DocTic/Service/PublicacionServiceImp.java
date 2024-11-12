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

    @Override
    public PublicacionModel actualizarPublicacion(PublicacionModel publicacion) {
        
        Optional<PublicacionModel> publicacionExistente = repository.findById(publicacion.getId());

        if (publicacionExistente.isPresent()) {
            return repository.save(publicacion);
        } else {
            throw new RecursoNoEncontradoException("No se encontró la publicación con ID " + publicacion.getId() + ". Verifique el ID e intente nuevamente.");
        }
    }

    @Override
    public String eliminarPublicacion(ObjectId id) {
        Optional<PublicacionModel> publicacionExistente = repository.findById(id);
        
        if (publicacionExistente.isPresent()) {
            repository.deleteById(id);
            return "Se eliminó la publicación con ObjectId: " + id.toString();
        } else {
            throw new RecursoNoEncontradoException("No se encontró la publicación con ID " + id + ". Verifique el ID e intente nuevamente.");
        }
    }


}
