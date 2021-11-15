package com.vacunapp2.vacunapp.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.vacunapp2.vacunapp.exceptions.CustomException;
import com.vacunapp2.vacunapp.models.LaboratorioModel;
import com.vacunapp2.vacunapp.services.LaboratorioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
@RequestMapping("/laboratorios")
public class LaboratorioController {

    @Autowired
    LaboratorioService laboratorioService;

    @GetMapping()
    public ArrayList<LaboratorioModel> obtenerLaboratorio(){
        return laboratorioService.obtenerLaboratorios();
    }

    @PostMapping()
    public ResponseEntity<Map<String, String>> guardarLaboratorio(@RequestBody LaboratorioModel laboratorio, Errors error){
        if(error.hasErrors()){
            throwError(error);
        }

        this.laboratorioService.guardarLaboratorio(laboratorio);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Laboratorio creado con éxito.");
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping(path = "/{id}")
    public Optional<LaboratorioModel> obtenerLaboratorioPorId(@PathVariable("id") String id){
        return this.laboratorioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<LaboratorioModel> obtenerLaboratorioPorNombre(@RequestParam("laboratorio") String laboratorio){
        return this.laboratorioService.obtenerPorLaboratorio(laboratorio);
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
