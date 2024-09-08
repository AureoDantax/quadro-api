package com.quadro.api.controller;


import com.quadro.api.dto.UsuarioRequestDTO;
import com.quadro.api.dto.UsuarioResponseDTO;
import com.quadro.api.service.AuthService;
import com.quadro.api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;


    @PostMapping("/cadastrar")
    public UsuarioResponseDTO cadastrarUsuario(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        var usuarioEntity = usuarioService.cadastrarUsuario(usuarioRequestDTO);


        return new UsuarioResponseDTO(usuarioEntity);
    }


}




