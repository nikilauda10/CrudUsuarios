package com.example.u3holamundo.service;

import com.example.u3holamundo.model.Usuario;
import com.example.u3holamundo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario unUsuario){
      Usuario usuarioExistente = usuarioRepository.findOneByEmail(unUsuario.getEmail());
      if (usuarioExistente != null){
          throw new RuntimeException("El mail ya esta registrado");
      }
      Usuario usuarioGuardado = usuarioRepository.save(unUsuario);
      return usuarioGuardado;
    }

    //Aqui tenemos que elegir la de spring no la de jakarta.
    @Transactional(readOnly = true)
    public List<Usuario> consultarUsuario(){
        return usuarioRepository.findAll();
    }

}
