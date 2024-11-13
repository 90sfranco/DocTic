package com.backend.DocTic.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.DocTic.Exception.RecursoNoEncontradoException;
import com.backend.DocTic.Model.DocumentoModel;
import com.backend.DocTic.Model.PublicacionModel;
import com.backend.DocTic.Model.UsuarioModel;
import com.backend.DocTic.Repository.IDocumentoRepository;
import com.backend.DocTic.Repository.IPublicacionRepository;
import com.backend.DocTic.Repository.IUsuarioRepository;

@Service
public class PublicacionServiceImp implements IPublicacionService{
    @Autowired
    IPublicacionRepository repository;
    @Autowired
    IUsuarioRepository usuarioRepository;
    @Autowired
    IDocumentoRepository documentoRepository;

    @Override
    public String insertarPublicacion(PublicacionModel publicacion) {
    
        Optional<UsuarioModel> usuarioOpt = usuarioRepository.findById(publicacion.getUsuario().getUsuarioId());
        Optional<DocumentoModel> documentoOpt = documentoRepository.findById(publicacion.getDocumento().getDocumentoId());
    
        if (!usuarioOpt.isPresent()) {
            throw new RuntimeException("El usuario no existe en la base de datos");
        }
    
        UsuarioModel usuario = usuarioOpt.get();
        validarInformacionUsuario(publicacion, usuario);
    
        // Validar que la fecha de publicación sea la actual
        LocalDate fechaActual = LocalDate.now(ZoneId.of("UTC"));
        LocalDate fechaPublicacion = publicacion.getFechaPub().toInstant().atZone(ZoneId.of("UTC")).toLocalDate();
        if (!fechaPublicacion.equals(fechaActual)) {
            throw new IllegalArgumentException("La fecha de publicación debe ser igual a la fecha actual.");
        }
    
        if (!documentoOpt.isPresent()) {
            throw new RuntimeException("El documento no existe en la base de datos");
        }
    
        DocumentoModel documento = documentoOpt.get();
        validarRolDelUsuario(publicacion, usuario, documento);
        validarInformacionDocumento(publicacion, documento);
    
        repository.insert(publicacion);
        return "Se insertó la publicación con éxito";
    }
    
    private void validarInformacionUsuario(PublicacionModel publicacion, UsuarioModel usuario) {
        if (!usuario.getNombre().equals(publicacion.getUsuario().getNombre()) ||
            !usuario.getNumDocumento().equals(publicacion.getUsuario().getNumDocumento())) {
            throw new RuntimeException("La información del usuario es incorrecta");
        }
    }
    
    private void validarRolDelUsuario(PublicacionModel publicacion, UsuarioModel usuario, DocumentoModel documento) {
        ObjectId primerAutorId = documentoRepository.findFirstAuthorById(documento.getId());
        String rolUsuario = publicacion.getUsuario().getRol().toString();
        boolean esAutorPrincipal = primerAutorId.equals(usuario.getId());
    
        if (esAutorPrincipal && !rolUsuario.equals("autor")) {
            throw new RuntimeException("El usuario es el autor principal del documento; el rol debe ser 'autor'");
        } else if (!esAutorPrincipal && rolUsuario.equals("autor") && !documento.getAutoresArr().isEmpty()) {
            throw new RuntimeException("El documento ya tiene un autor principal; el rol debe ser 'coautor'");
        } else if (documento.getAutoresArr().isEmpty() && !rolUsuario.equals("autor")) {
            throw new RuntimeException("El documento es nuevo; el rol del usuario debe ser 'autor'");
        }
    }
    
    private void validarInformacionDocumento(PublicacionModel publicacion, DocumentoModel documento) {
        if (!documento.getNombre().equals(publicacion.getDocumento().getNombre()) ||
            !documento.getEstado().equals(publicacion.getDocumento().getEstado())) {
            throw new RuntimeException("La información del documento es incorrecta");
        }
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
        Optional<PublicacionModel> publicacionExistenteOpt = repository.findById(publicacion.getId());
    
        if (!publicacionExistenteOpt.isPresent()) {
            throw new RecursoNoEncontradoException("No se encontró la publicación con ID " + publicacion.getId() + ". Verifique el ID e intente nuevamente.");
        }
    
        PublicacionModel publicacionExistente = publicacionExistenteOpt.get();
    
        //Validar la existencia del usuario y del documento
        Optional<UsuarioModel> usuarioOpt = usuarioRepository.findById(publicacion.getUsuario().getUsuarioId());
        Optional<DocumentoModel> documentoOpt = documentoRepository.findById(publicacion.getDocumento().getDocumentoId());
    
        if (!usuarioOpt.isPresent()) {
            throw new RuntimeException("El usuario no existe en la base de datos");
        }
        if (!documentoOpt.isPresent()) {
            throw new RuntimeException("El documento no existe en la base de datos");
        }
    
        UsuarioModel usuario = usuarioOpt.get();
        DocumentoModel documento = documentoOpt.get();
    
        //Validar la información del usuario
        validarInformacionUsuario(publicacion, usuario);
    
        //Validar que la fecha de publicación no se haya modificado
        if (!publicacionExistente.getFechaPub().equals(publicacion.getFechaPub())) {
            throw new IllegalArgumentException("La fecha de publicación no puede ser modificada.");
        }
    
        //Validar el rol del usuario
        validarRolDelUsuario(publicacion, usuario, documento);
    
        //Validar la información del documento
        validarInformacionDocumento(publicacion, documento);
    
        return repository.save(publicacion);
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
