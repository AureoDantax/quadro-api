package com.quadro.api.model;

import lombok.Getter;

@Getter
public enum TIPOUSUARIO {
    ADMIN("administrador"),
    STUDENT("aluno"),
    TEACHER("professor");

    private final String descricao;

    TIPOUSUARIO(String descricao) {
        this.descricao = descricao;
    }

    public static TIPOUSUARIO fromDescricao(String descricao) {
        for (TIPOUSUARIO tipo : TIPOUSUARIO.values()) {
            if (tipo.getDescricao().equalsIgnoreCase(descricao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Descrição de tipo de usuário inválida: " + descricao);
    }
}