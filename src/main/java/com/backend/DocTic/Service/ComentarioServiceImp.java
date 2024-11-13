package com.backend.DocTic.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.DocTic.Exception.RecursoNoEncontradoException;
import com.backend.DocTic.Model.ComentarioModel;
import com.backend.DocTic.Repository.IComentarioRepository;

@Service
public class ComentarioServiceImp implements IComentarioService{
    @Autowired
    IComentarioRepository repository;
    
    @Override
    public String insertarComentario(ComentarioModel comentario){
        repository.insert(comentario);
        return "Se insertó el comentario con éxito";
    }

    @Override
    public ComentarioModel obtenerComentario(ObjectId id) {
       Optional<ComentarioModel> comentarioEncontrado = repository.findById(id);
       return comentarioEncontrado.orElseThrow(()-> new RecursoNoEncontradoException("No se encontró el comentario con ID"+id+"por favor verifica el ID"));
    }

    @Override
    public List<ComentarioModel> obtenerComentarios() {
        return repository.findAll();
    }

    @Override
    public ComentarioModel actulizarComentario(ComentarioModel comentario) {
        Optional<ComentarioModel> comentarioExistente = repository.findById(comentario.getId());

        if (comentarioExistente.isPresent()) {
            return repository.save(comentario);
        }
        else {
            throw new RecursoNoEncontradoException("No se encontró el comentario con ID"+comentario.getId()+".Verifique por favor el ID.");
        }
    }

    @Override
    public String eliminarComentario(ObjectId id) {
        Optional<ComentarioModel> comentarioExistente = repository.findById(id);

        if (comentarioExistente.isPresent()) {
            repository.deleteById(id);
            return "Se eliminó el comentario con ObjectId: "+id.toString();
        }
        else {
            throw new RecursoNoEncontradoException("No se encontro el comentario con ID"+id+". Verifica tu ID e intenta nuevamente.");
        }
    }
}
