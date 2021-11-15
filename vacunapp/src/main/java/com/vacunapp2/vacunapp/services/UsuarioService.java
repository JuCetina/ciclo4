package com.vacunapp2.vacunapp.services;

import java.util.ArrayList;
import java.util.Optional;

import com.vacunapp2.vacunapp.models.UsuarioModel;
import com.vacunapp2.vacunapp.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public ArrayList<UsuarioModel> obtenerUsuario(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> obtenerPorId(String id){
        return usuarioRepository.findById(id);
    }

    public UsuarioModel obtenerPorUsername(String username){
        return usuarioRepository.findByUsername(username).orElse(new UsuarioModel());
    }
}
