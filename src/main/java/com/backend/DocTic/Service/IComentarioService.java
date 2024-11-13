package com.backend.DocTic.Service;

import java.util.List;

import org.bson.types.ObjectId;

import com.backend.DocTic.Model.ComentarioModel;

public interface IComentarioService {
    String insertarComentario(ComentarioModel comentario);

    ComentarioModel obtenerComentario(ObjectId id);

    List<ComentarioModel> obtenerComentarios();

    ComentarioModel actulizarComentario(ComentarioModel comentario);

    String eliminarComentario(ObjectId id);
}
