package com.quadro.api.service;

import com.quadro.api.dto.UsuarioRequestDTO;
import com.quadro.api.model.TIPOUSUARIO;
import com.quadro.api.model.Usuario;
import com.quadro.api.repository.TipoUsuarioRepository;
import com.quadro.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public Usuario cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        var normalizeTipo = TIPOUSUARIO.fromDescricao(usuarioRequestDTO.getTipoUsuario());
        var tipoUsuarioEntity = tipoUsuarioRepository.findByTipo(normalizeTipo);
var usuario = new Usuario(
        usuarioRequestDTO.getNome(),
        usuarioRequestDTO.getApelido(),
        usuarioRequestDTO.getEmail(), // login tambem é o email por enquanto
        usuarioRequestDTO.getCpf(),
        usuarioRequestDTO.getEmail(),
        passwordEncoder.encode(usuarioRequestDTO.getSenha()),
        usuarioRequestDTO.getTelefone(),
        usuarioRequestDTO.getInstituicao(),
        tipoUsuarioEntity
);

        return usuarioRepository.save(usuario);
    }
}
