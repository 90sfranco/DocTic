package com.backend.DocTic.Service;

import org.bson.types.ObjectId;

import com.backend.DocTic.Model.DocumentoModel;

public interface IDocumentoService {

    DocumentoModel obtenerDocumento(ObjectId id);
    
}
