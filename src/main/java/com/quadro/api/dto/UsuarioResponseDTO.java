package com.quadro.api.dto;

import com.quadro.api.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String nomeExibicao;
    private String email;
    private String tipoUsuario;

   public UsuarioResponseDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.nomeExibicao = usuario.getNomeExibicao();
        this.email = usuario.getEmail();
        this.tipoUsuario = usuario.getTipoUsuario().getTipo().getDescricao();
    }
}
