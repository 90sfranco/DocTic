package com.backend.DocTic.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.backend.DocTic.Exception.RecursoNoEncontradoException;
import com.backend.DocTic.Model.ComentarioModel;
import com.backend.DocTic.Repository.IComentarioRepository;
import com.backend.DocTic.Repository.IDocumentoRepository;
import com.backend.DocTic.Repository.IUsuarioRepository;
import com.backend.DocTic.Repository.IvisualizacionRepository;

@Service
public class ComentarioServiceImp implements IComentarioService{
    @Autowired
    IComentarioRepository repository;
    @Autowired
    IUsuarioRepository usuarioRepository;
    @Autowired
    IDocumentoRepository documentoRepository;
    @Autowired 
    IvisualizacionRepository visualizacionRepository;

    /**
     * Método para eliminae un comentario y todos los comentarios que lo referencian con comPadreId.
     */
    private void eliminarComentarioYReferencias(ObjectId id) {
        // Eliminar el comentario actual
        repository.deleteById(id);

        // Buscar comentarios que tengan el id actual como comPadreId
        List<ComentarioModel> comentariosHijos = repository.findByComPadreId(id);

        // Eliminar recursivamente cada comentario hijo
        for (ComentarioModel hijo : comentariosHijos) {
            eliminarComentarioYReferencias(hijo.getId());
        }
    }
    
    @Override
    public String insertarComentario(ComentarioModel comentario){

        //Validar que el usuario existe
        Assert.notNull(comentario.getUsuarioId(), "El ID del usuario no debe ser nulo");
        if (!usuarioRepository.existsById(comentario.getUsuarioId())) {
            throw new IllegalArgumentException("El usuario especificado no existe.");
        }
        
        //Validar que el documento existe
        Assert.notNull(comentario.getDocumentoId(), "El ID del documento no debe ser nulo");
        if (!documentoRepository.existsById(comentario.getDocumentoId())) {
            throw new IllegalArgumentException("El documento especificado no existe.");
        }

      
        //Validar que el documento fue visualizado por el usuario antes de comentar
        boolean visualizacionExiste = visualizacionRepository.existsByUsuarioIdAndDocumentoId(
            comentario.getUsuarioId(),
            comentario.getDocumentoId()
        );
        if (!visualizacionExiste) {
            throw new IllegalArgumentException("El usuario debe haber visualizado el documento antes de comentar.");
        }

        // Validar que el comentario padre existe y está asociado al mismo documento
        if (comentario.getComPadreId() != null) {
            Optional<ComentarioModel> comentarioPadre = repository.findById(comentario.getComPadreId());

            if (!comentarioPadre.isPresent()) {
                throw new IllegalArgumentException("El comentario padre especificado no existe.");
            }

            // Verificar que el documento del comentario padre sea el mismo
            if (!comentarioPadre.get().getDocumentoId().equals(comentario.getDocumentoId())) {
                throw new IllegalArgumentException("El comentario solo puede responder a comentarios del mismo documento.");
            }
        }

        //Validar que la fecha del comentario sea actual
        LocalDate fechaActual = LocalDate.now(ZoneId.of("UTC"));
        LocalDate fechaComentario = comentario.getFecha().toInstant().atZone(ZoneId.of("UTC")).toLocalDate();
        
        if (!fechaComentario.equals(fechaActual)) {
            throw new IllegalArgumentException("La fecha del comentario debe ser la fecha actual.");
        }

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
        // Obtener el comentario existente para aplicar las restricciones
        Optional<ComentarioModel> comentarioExistenteOpt = repository.findById(comentario.getId());

        if (!comentarioExistenteOpt.isPresent()) {
            throw new RecursoNoEncontradoException("No se encontró el comentario con ID " + comentario.getId() + ". Verifique por favor el ID.");
        }

        //Validar que el usuario existe
        Assert.notNull(comentario.getUsuarioId(), "El ID del usuario no debe ser nulo");
        if (!usuarioRepository.existsById(comentario.getUsuarioId())) {
            throw new IllegalArgumentException("El usuario especificado no existe.");
        }

        //Validar que el documento existe
        Assert.notNull(comentario.getDocumentoId(), "El ID del documento no debe ser nulo");
        if (!documentoRepository.existsById(comentario.getDocumentoId())) {
            throw new IllegalArgumentException("El documento especificado no existe.");
        }

        //Validar que el usuario ha visualizado el documento antes de actualizar
        boolean visualizacionExiste = visualizacionRepository.existsByUsuarioIdAndDocumentoId(
                comentario.getUsuarioId(),
                comentario.getDocumentoId()
        );

        if (!visualizacionExiste) {
            throw new IllegalArgumentException("El usuario debe haber visualizado el documento antes de actualizar el comentario.");
        }

        // Validar que el comentario padre existe y está asociado al mismo documento, si está definido
        if (comentario.getComPadreId() != null) {
            Optional<ComentarioModel> comentarioPadreOpt = repository.findById(comentario.getComPadreId());
            if (!comentarioPadreOpt.isPresent()) {
                throw new IllegalArgumentException("El comentario padre especificado no existe.");
            }

            // Verificar que el documento del comentario padre sea el mismo que el documento actual
            if (!comentarioPadreOpt.get().getDocumentoId().equals(comentario.getDocumentoId())) {
                throw new IllegalArgumentException("El comentario solo puede responder a comentarios del mismo documento.");
            }
        }
         //Validar que la fecha del comentario sea actual
         LocalDate fechaActual = LocalDate.now(ZoneId.of("UTC"));
         LocalDate fechaComentario = comentario.getFecha().toInstant().atZone(ZoneId.of("UTC")).toLocalDate();
         
         if (!fechaComentario.equals(fechaActual)) {
             throw new IllegalArgumentException("La fecha del comentario debe ser la fecha actual.");
         }


        return repository.save(comentario);
    }

    @Override
    public String eliminarComentario(ObjectId id) {
        Optional<ComentarioModel> comentarioExistente = repository.findById(id);

        if (comentarioExistente.isPresent()) {
            eliminarComentarioYReferencias(id);
            return "Se eliminó el comentario con ObjectId: " + id.toString() + " y todos sus comentarios hijos.";
        }
        else {
            throw new RecursoNoEncontradoException("No se encontró el comentario con ID " + id + ".");
        }
    }
}
