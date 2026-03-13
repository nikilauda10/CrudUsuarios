package com.example.u3holamundo.controller;

import com.example.u3holamundo.controller.dto.CreateUserDto;
import com.example.u3holamundo.model.Usuario;
import com.example.u3holamundo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public List<Usuario> consultarUsuarios(){
        List<Usuario> usuarios = usuarioService.consultarUsuario();
        return usuarios;
    }


    @PostMapping
    public Usuario registrarUsuario(@Valid @RequestBody CreateUserDto dto){
        Usuario usuarioNuevo = usuarioService.guardarUsuario(dto);
        return usuarioNuevo;
    }
}
