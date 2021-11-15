package com.vacunapp2.vacunapp.repositories;

import java.util.ArrayList;

import com.vacunapp2.vacunapp.models.LaboratorioModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratorioRepository extends MongoRepository<LaboratorioModel, String>{
    public abstract ArrayList<LaboratorioModel> findByLaboratorio(String laboratorio);
}
