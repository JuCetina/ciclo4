package com.vacunapp2.vacunapp.repositories;

import java.util.ArrayList;

import com.vacunapp2.vacunapp.models.PacienteModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends MongoRepository<PacienteModel, String>{
    public abstract ArrayList<PacienteModel> findByNombre(String nombre);
}
