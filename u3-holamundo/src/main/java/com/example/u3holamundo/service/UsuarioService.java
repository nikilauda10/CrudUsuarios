package com.example.u3holamundo.service;

import com.example.u3holamundo.controller.dto.CreateUserDto;
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

    public Usuario guardarUsuario(CreateUserDto unDto){
      Usuario usuarioExistente = usuarioRepository.findOneByEmail(unDto.getCorreo());
      if (usuarioExistente != null){
          throw new RuntimeException("El mail ya esta registrado");
      }
      Usuario unusuario = new Usuario();
      unusuario.setNombre(unDto.getNombre());
      unusuario.setApellido(unDto.getApellido());
      unusuario.setEmail(unDto.getCorreo());
      Usuario usuarioGuardado = usuarioRepository.save(unusuario);
      return usuarioGuardado;
    }


    //Aqui tenemos que elegir la de spring no la de jakarta.
    @Transactional(readOnly = true)
    public List<Usuario> consultarUsuario(){
        return usuarioRepository.findAll();
    }

}
