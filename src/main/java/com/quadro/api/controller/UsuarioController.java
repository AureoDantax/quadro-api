package com.quadro.api.controller;


import com.quadro.api.dto.UsuarioRequestDTO;
import com.quadro.api.dto.UsuarioResponseDTO;
import com.quadro.api.service.AuthService;
import com.quadro.api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    AuthService authService;

    @PostMapping("/cadastrar")
    public UsuarioResponseDTO cadastrarUsuario(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        var usuarioEntity = usuarioService.cadastrarUsuario(usuarioRequestDTO);


        return new UsuarioResponseDTO(usuarioEntity);
    }


}




