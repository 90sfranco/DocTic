package com.backend.DocTic.Service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.DocTic.Exception.RecursoNoEncontradoException;
import com.backend.DocTic.Model.DocumentoModel;
import com.backend.DocTic.Repository.IDocumentoRepository;

@Service
public class DocumentoServiceImp implements IDocumentoService{
    @Autowired
    IDocumentoRepository documentoRepository;

    @Override
    public DocumentoModel obtenerDocumento(ObjectId id) {
        
       Optional<DocumentoModel> documentoEncontrado = documentoRepository.findById(id);
        return documentoEncontrado.orElseThrow(()-> new RecursoNoEncontradoException("No se encontró el documento con ObjectId "+id));
    }

    
}
