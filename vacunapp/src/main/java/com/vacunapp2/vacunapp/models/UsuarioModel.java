package com.vacunapp2.vacunapp.models;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
public class UsuarioModel {
    
    @Id
    private String id;

    @NotEmpty(message = "El nombre no puede ser vacío.")
    private String nombre;

    @NotEmpty(message = "El correo no puede ser vacío.")
    private String correo;

    @NotEmpty(message = "El username no puede ser vacío.")
    private String username;

    @NotEmpty(message = "El password no puede ser vacío.")
    private String password;
    
    private String hash;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getHash() {
        return hash;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }
}
