package com.backend.DocTic.Model;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuarios")
public class UsuarioModel {
    @Id
    private String id;

    private String numDocumento;
    private String nombre;
    private String userName;
    private String correo;
    private String pSecreta;
    private String rSecreta;
    private String direccion;
    private String ciudadOrigen;
    private String depOrigen;

    private List<String> contrasenasArr; // Array de ObjectId que hace referencia a Contrasenaas 


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPSecreta() {
        return pSecreta;
    }

    public void setPSecreta(String pSecreta) {
        this.pSecreta = pSecreta;
    }

    public String getRSecreta() {
        return rSecreta;
    }

    public void setRSecreta(String rSecreta) {
        this.rSecreta = rSecreta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getDepOrigen() {
        return depOrigen;
    }

    public void setDepOrigen(String depOrigen) {
        this.depOrigen = depOrigen;
    }

    public List<String> getContrasenasArr() {
        return contrasenasArr;
    }

    public void setContrasenasArr(List<String> contrasenasArr) {
        this.contrasenasArr = contrasenasArr;
    }
}
