package com.quadro.api.dto;

import com.quadro.api.model.ImagemPerfil;
import lombok.Getter;

@Getter
public class UsuarioRequestDTO {
    private String nome;
    private String apelido;
    private String cpf;
    private String email;
    private String senha;
    private String telefone;
    private String instituicao;
    private String tipoUsuario;
    private ImagemPerfil imagemPerfil;
}
