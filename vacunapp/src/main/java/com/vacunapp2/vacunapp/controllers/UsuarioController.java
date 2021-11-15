package com.vacunapp2.vacunapp.controllers;

import java.util.HashMap;
import java.util.Map;

import com.vacunapp2.vacunapp.exceptions.CustomException;
import com.vacunapp2.vacunapp.models.UsuarioModel;
import com.vacunapp2.vacunapp.services.UsuarioService;
import com.vacunapp2.vacunapp.utils.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<Map<String, String>> guardarUsuario(@RequestBody UsuarioModel usuario, Errors error){
        if(error.hasErrors()){
            throwError(error);
        }

        Map<String, String> respuesta = new HashMap<>();

        usuario.setPassword(BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt()));

        UsuarioModel u = usuarioService.obtenerPorUsername(usuario.getUsername());

        if(u.getId() == null){
            usuarioService.guardarUsuario(usuario);
            respuesta.put("mensaje", "Se creó el usuario exitosamente.");
        }else{
            respuesta.put("mensaje", "El usuario ya está registrado.");
        }

        return ResponseEntity.ok(respuesta);
    }

    public void throwError(Errors error){
        String mensaje = "";
        int index = 0;
        for(ObjectError e: error.getAllErrors()){
            if(index > 0){
                mensaje += " | ";
                
            }
            mensaje += String.format("Parámetro: %s - Mensaje: %s", e.getObjectName(), e.getDefaultMessage());
        }
        throw new CustomException(mensaje);
    }
}
