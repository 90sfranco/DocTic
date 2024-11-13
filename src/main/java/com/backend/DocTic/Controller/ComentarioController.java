package com.backend.DocTic.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.DocTic.Exception.RecursoNoEncontradoException;
import com.backend.DocTic.Model.ComentarioModel;
import com.backend.DocTic.Service.IComentarioService;

@RestController
@RequestMapping("/apiewb/comentarios")
public class ComentarioController {
    
    @Autowired
    IComentarioService service;

    @PostMapping("/insertar")
    public ResponseEntity<?> postComentario(@RequestBody ComentarioModel comentario){
        try {
            return new ResponseEntity<String>(service.insertarComentario(comentario), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Ocurrió un error al insertar el comentario: "+ e.getMessage().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<ComentarioModel> obtenerComentarioPorId(@PathVariable ObjectId id){
        try {
            ComentarioModel comentario = service.obtenerComentario(id);
            return ResponseEntity.ok(comentario);
        }
        catch (RecursoNoEncontradoException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/obtener")
    public ResponseEntity<List<ComentarioModel>> obtenerTodasLosComentarios() {
        List<ComentarioModel> comentarios = service.obtenerComentarios();
        return ResponseEntity.ok(comentarios);
    }

    @PutMapping("/actualizar/{objectId}")
    public ResponseEntity <ComentarioModel> actualizarComentario(@PathVariable ObjectId objectId, @RequestBody ComentarioModel comentario) {
        try{
            comentario.setId(objectId);
            ComentarioModel comentarioActualizado = service.actulizarComentario(comentario);
            return ResponseEntity.ok(comentarioActualizado);
        }catch (RecursoNoEncontradoException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteComentario(@PathVariable ObjectId id) {
        try {
            return new ResponseEntity<String> (service.eliminarComentario(id), HttpStatus.OK);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.notFound().build(); 
        }
    }
}
