package com.vacunapp2.vacunapp.services;

import java.util.ArrayList;
import java.util.Optional;

import com.vacunapp2.vacunapp.models.LaboratorioModel;
import com.vacunapp2.vacunapp.repositories.LaboratorioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaboratorioService {
    @Autowired
    LaboratorioRepository laboratorioRepository;

    public ArrayList<LaboratorioModel> obtenerLaboratorios(){
        return (ArrayList<LaboratorioModel>) laboratorioRepository.findAll();
    }

    public LaboratorioModel guardarLaboratorio(LaboratorioModel laboratorio){
        return laboratorioRepository.save(laboratorio);
    }

    public Optional<LaboratorioModel> obtenerPorId(String id){
        return laboratorioRepository.findById(id);
    }

    public ArrayList<LaboratorioModel> obtenerPorLaboratorio(String laboratorio){
        return laboratorioRepository.findByLaboratorio(laboratorio);
    }
}
