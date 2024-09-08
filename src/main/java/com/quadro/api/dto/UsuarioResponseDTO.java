package com.quadro.api.dto;

import com.quadro.api.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String apelido;
    private String email;
    private String tipoUsuario;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.apelido = usuario.getApelido();
        this.email = usuario.getEmail();
        this.tipoUsuario = usuario.getTipoUsuario().getTipo().getDescricao();
    }
}
