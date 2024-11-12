package com.backend.DocTic.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.DocTic.Exception.RecursoNoEncontradoException;
import com.backend.DocTic.Model.PublicacionModel;
import com.backend.DocTic.Service.IPublicacionService;

@RestController
@RequestMapping("/apiewb/publicaciones")
public class PublicacionesController {

    @Autowired
    IPublicacionService service;

    @PostMapping("/insertar")
    public ResponseEntity<?> postPublicaciones(@RequestBody PublicacionModel publicacion){
        try {
            return new ResponseEntity<String>(service.insertarPublicacion(publicacion), HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity<String>("Ocurrió un error al insertar la publicación: "+ e.getMessage().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     @GetMapping("/obtener/{id}")
    public ResponseEntity<PublicacionModel> obtenerPublicacionPorId(@PathVariable ObjectId id) {
        try {
            PublicacionModel publicacion =service.obtenerPublicacion(id);
            return ResponseEntity.ok(publicacion);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener todas las publicaciones
    @GetMapping("/obtener")
    public ResponseEntity<List<PublicacionModel>> obtenerTodasLasPublicaciones() {
        List<PublicacionModel> publicaciones = service.obtenerPublicaciones();
        return ResponseEntity.ok(publicaciones);
    }
}

