package com.vacunapp2.vacunapp.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.vacunapp2.vacunapp.exceptions.CustomException;
import com.vacunapp2.vacunapp.models.PacienteModel;
import com.vacunapp2.vacunapp.services.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/pacientes")
public class PacienteController {
    

    @Autowired
    PacienteService pacienteService;

    @GetMapping()
    public ArrayList<PacienteModel> obtenerPaciente(){
        return pacienteService.obtenerPacientes();
    }

    @PostMapping()
    public PacienteModel guardarPacientes(@RequestBody PacienteModel paciente, Errors error){
        if(error.hasErrors()){
            throwError(error);
        }
        
        return this.pacienteService.guardarPaciente(paciente);
    }

    @GetMapping(path = "/{cedula}")
    public Optional<PacienteModel> obtenerPacientePorCedula(@PathVariable("cedula") String cedula){
        return this.pacienteService.obtenerPorCedula(cedula);
    }

    @GetMapping("/query")
    public ArrayList<PacienteModel> obtenerPacientePorNombre(@RequestParam("nombre") String nombre){
        return this.pacienteService.obtenerPorNombre(nombre);
    }

    @DeleteMapping(path = "/{cedula}")
    public String eliminarPacientePorId(@PathVariable("cedula") String cedula){
        boolean eliminado = this.pacienteService.eliminarPaciente(cedula);
        if(eliminado){
            return "Se ha eliminado el paciente con cédula: " + cedula;
        }
        else{
            return "Ocurrió un error, no fue posible eliminar el paciente.";
        }
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
