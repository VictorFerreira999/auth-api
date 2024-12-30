package io.victorferreira.auth_api.controllers;

import io.victorferreira.auth_api.dtos.UsuarioDto;
import io.victorferreira.auth_api.models.Usuario;
import io.victorferreira.auth_api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    private UsuarioDto salvar(@RequestBody UsuarioDto usuarioDto){
        return usuarioService.salvar(usuarioDto);
    }

    @GetMapping
    private String getOk(){
        return "OK";
    }
}
