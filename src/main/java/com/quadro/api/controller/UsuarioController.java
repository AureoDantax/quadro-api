package com.quadro.api.controller;


import com.quadro.api.dto.UsuarioRequestDTO;
import com.quadro.api.dto.UsuarioResponseDTO;
import com.quadro.api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.created;


@RestController
@RequestMapping("api/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;


    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponseDTO> cadastrarUsuario(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        var usuarioEntity = usuarioService.cadastrarUsuario(usuarioRequestDTO);
        return created(null).body(new UsuarioResponseDTO(usuarioEntity));

    }


}




