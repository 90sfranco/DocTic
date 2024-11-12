package com.backend.DocTic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
