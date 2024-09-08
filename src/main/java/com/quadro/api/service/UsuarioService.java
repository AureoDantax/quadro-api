package com.quadro.api.service;

import com.quadro.api.dto.UsuarioRequestDTO;
import com.quadro.api.model.TIPOUSUARIO;
import com.quadro.api.model.TipoUsuarioEntity;
import com.quadro.api.model.Usuario;
import com.quadro.api.repository.TipoUsuarioRepository;
import com.quadro.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public Usuario cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        TipoUsuarioEntity tipoUsuarioEntity;
        TIPOUSUARIO normalizeTipo = TIPOUSUARIO.fromDescricao(usuarioRequestDTO.getTipoUsuario());

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDTO.getNome() + " " + usuarioRequestDTO.getSobrenome());
        usuario.setNomeExibicao(usuarioRequestDTO.getNomeExibicao());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        tipoUsuarioEntity = tipoUsuarioRepository.findByTipo(normalizeTipo);
        usuario.setTipoUsuario(tipoUsuarioEntity);
        usuario.setCpf(usuarioRequestDTO.getCpf());
        usuario.setLogin(usuarioRequestDTO.getEmail());
        usuario.setSenha(usuarioRequestDTO.getSenha());
        usuario.setTelefone(usuarioRequestDTO.getTelefone());
        usuario.setInstituicao(usuarioRequestDTO.getInstituicao());
        usuario.setImagemPerfil(usuarioRequestDTO.getImagemPerfil());
        usuarioRepository.save(usuario);


        return usuario;
    }
}
