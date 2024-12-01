package com.quadro.api.service;

import com.quadro.api.dto.UsuarioRequestDTO;
import com.quadro.api.model.TIPOUSUARIO;
import com.quadro.api.model.Usuario;
import com.quadro.api.repository.TipoUsuarioRepository;
import com.quadro.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario editarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        var usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com id: " + id));

        var tipoUsuario = tipoUsuarioRepository.findByTipo(TIPOUSUARIO.fromDescricao(usuarioRequestDTO.getTipoUsuario()));

        usuarioExistente.setNome(usuarioRequestDTO.getNome());
        usuarioExistente.setApelido(usuarioRequestDTO.getApelido());
        usuarioExistente.setCpf(usuarioRequestDTO.getCpf());
        usuarioExistente.setEmail(usuarioRequestDTO.getEmail());
        usuarioExistente.setSenha(passwordEncoder.encode(usuarioRequestDTO.getSenha()));
        usuarioExistente.setTelefone(usuarioRequestDTO.getTelefone());
        usuarioExistente.setInstituicao(usuarioRequestDTO.getInstituicao());
        usuarioExistente.setTipoUsuario(tipoUsuario);
        if (usuarioRequestDTO.getImagemPerfil() != null) {
            usuarioExistente.setImagemPerfil(usuarioRequestDTO.getImagemPerfil());
        }

        return usuarioRepository.save(usuarioExistente);
    }

    public void excluirUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuário não encontrado com id: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}
