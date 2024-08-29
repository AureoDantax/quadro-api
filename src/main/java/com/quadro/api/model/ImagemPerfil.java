package com.quadro.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Table(name = "imagem_perfil")
@Entity
@Data
public class ImagemPerfil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Lob
    @Column(name = "imagem", columnDefinition = "BLOB")
    private byte[] imagem;
}
