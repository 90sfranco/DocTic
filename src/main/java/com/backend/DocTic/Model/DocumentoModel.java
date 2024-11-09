package com.backend.DocTic.Model;
import java.util.List;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Documentos")
public class DocumentoModel {
     @Id
    private String id;

    private String descripcion;
    private String nombre;
    private String url;
    private String estado; // "publico" o "privdo"
    private Date fechaPub;

    private List<Categoria> categoriasArr; // Lista de categorías embebidas

    // Subdocumento para la estructura de cada categoría
    public static class Categoria {
        private String categoriaId; // ObjectId en MongoDB
        private String nombre;

        // Getters y Setters Categoria

        public String getCategoriaId() {
            return categoriaId;
        }

        public void setCategoriaId(String categoriaId) {
            this.categoriaId = categoriaId;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }

    // Getters y SettersDocumento

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(Date fechaPub) {
        this.fechaPub = fechaPub;
    }

    public List<Categoria> getCategoriasArr() {
        return categoriasArr;
    }

    public void setCategoriasArr(List<Categoria> categoriasArr) {
        this.categoriasArr = categoriasArr;
    }

}
