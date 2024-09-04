package com.quadro.api.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Bean;

@Entity
@Table(name = "tipo_usuario")
@Data
public class TipoUsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private TIPOUSUARIO tipo;
}