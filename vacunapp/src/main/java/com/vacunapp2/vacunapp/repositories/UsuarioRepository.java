package com.vacunapp2.vacunapp.repositories;

import java.util.Optional;

import com.vacunapp2.vacunapp.models.UsuarioModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioModel, String>{
    public Optional<UsuarioModel> findByUsername(String username);
}
