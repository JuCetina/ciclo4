package com.vacunapp2.vacunapp.exceptions;

public class ErrorMensaje {
    
    private String type;
    private String mensaje;

    public ErrorMensaje(String type, String mensaje){
        this.type = type;
        this.mensaje = mensaje;
    }

    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
}
