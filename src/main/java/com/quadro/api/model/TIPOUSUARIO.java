package com.quadro.api.model;

import lombok.Getter;

@Getter
public enum TIPOUSUARIO {
    ADMIN("Administrador"),
    STUDENT("Estudante"),
    TEACHER("Professor");

    private final String descricao;

    TIPOUSUARIO(String descricao) {
        this.descricao = descricao;
    }

}