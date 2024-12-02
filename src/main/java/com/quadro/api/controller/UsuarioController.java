package com.quadro.api.controller;


import com.quadro.api.dto.UsuarioRequestDTO;
import com.quadro.api.dto.UsuarioResponseDTO;
import com.quadro.api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
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
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios() {
        var usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios.stream().map(UsuarioResponseDTO::new).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> editarUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        var usuarioAtualizado = usuarioService.editarUsuario(id, usuarioRequestDTO);
        return ResponseEntity.ok(new UsuarioResponseDTO(usuarioAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }


}




