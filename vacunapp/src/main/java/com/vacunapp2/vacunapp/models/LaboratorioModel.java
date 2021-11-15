package com.vacunapp2.vacunapp.models;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="laboratorio")
public class LaboratorioModel {

    @Id
    private String id;

    @NotEmpty(message = "El laboratorio no puede ser vacío.")
    private String laboratorio;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getLaboratorio() {
        return laboratorio;
    }
    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    
}
