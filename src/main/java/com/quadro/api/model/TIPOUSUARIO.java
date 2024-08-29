package com.quadro.api.model;

public enum TIPOUSUARIO {
    ADMINISTRADOR("Administrador"),
    ESTUDANTE("Estudante"),
    PROFESSOR("Professor");

    private final String descricao;

    TIPOUSUARIO(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}