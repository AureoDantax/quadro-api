package com.quadro.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Table(name = "usuarios")
@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "O campo cpf é obrigatório")
    @CPF(message = "O cpf informado é inválido")
    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, length = 100)
    private String nome;
    private String sobrenome;

    @Column(nullable = false, length = 100)
    private String nomeExibicao;

    @Column(nullable = false, length = 100)
    private String senha;

    @Email
    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(length = 11, unique = true)
    private String telefone;

    @Column(nullable = false, length = 100)
    private String instituicao;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id", nullable = false)
    private TipoUsuarioEntity tipoUsuario;

    @JoinColumn(name = "imagem_perfil_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private ImagemPerfil imagemPerfil;
}