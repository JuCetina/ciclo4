package com.vacunapp2.vacunapp.models;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="paciente")
public class PacienteModel {

    @Id
    private String cedula;

    @NotEmpty(message = "El nombre del paciente no puede ser vacío.")
    private String nombre;

    @NotEmpty(message = "El telefono no puede ser vacío.")
    private String telefono;

    @NotEmpty(message = "La vacuna no puede ser vacía.")
    private LaboratorioModel laboratorio;

    @NotEmpty(message = "La primera dosis no puede ser vacía.")
    private Date primera_dosis;
    
    private Date segunda_dosis;
    private Boolean esquema_completo;
    private UsuarioModel usuario;


    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public LaboratorioModel getLaboratorio() {
        return laboratorio;
    }
    public void setLaboratorio(LaboratorioModel laboratorio) {
        this.laboratorio = laboratorio;
    }
    public Date getPrimera_dosis() {
        return primera_dosis;
    }
    public void setPrimera_dosis(Date primera_dosis) {
        this.primera_dosis = primera_dosis;
    }
    public Date getSegunda_dosis() {
        return segunda_dosis;
    }
    public void setSegunda_dosis(Date segunda_dosis) {
        this.segunda_dosis = segunda_dosis;
    }
    public Boolean getEsquema_completo() {
        return esquema_completo;
    }
    public void setEsquema_completo(Boolean esquema_completo) {
        this.esquema_completo = esquema_completo;
    }
    public UsuarioModel getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
    
}
