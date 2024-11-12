package com.backend.DocTic.Service;

import java.util.List;

import org.bson.types.ObjectId;

import com.backend.DocTic.Model.PublicacionModel;

public interface IPublicacionService {
    String insertarPublicacion(PublicacionModel publicacion);

    PublicacionModel obtenerPublicacion(ObjectId id);

    List<PublicacionModel> obtenerPublicaciones();
}
