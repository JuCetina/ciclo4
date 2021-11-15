package com.vacunapp2.vacunapp.services;

import java.util.ArrayList;
import java.util.Optional;

import com.vacunapp2.vacunapp.models.PacienteModel;
import com.vacunapp2.vacunapp.repositories.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public ArrayList<PacienteModel> obtenerPacientes(){
        return (ArrayList<PacienteModel>) pacienteRepository.findAll();
    }

    public PacienteModel guardarPaciente(PacienteModel paciente){
        return pacienteRepository.save(paciente);
    }

    public Optional<PacienteModel> obtenerPorCedula(String cedula){
        return pacienteRepository.findById(cedula);
    }

    public ArrayList<PacienteModel> obtenerPorNombre(String nombre){
        return pacienteRepository.findByNombre(nombre);
    }

    public boolean eliminarPaciente(String cedula){
        try{
            pacienteRepository.deleteById(cedula);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
