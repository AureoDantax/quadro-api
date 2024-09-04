package com.quadro.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "O campo cpf é obrigatório")
    @CPF(message = "O cpf informado é inválido")
    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;


    @Column(nullable = false, length = 100)
    private String nomeExibicao;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "O campo senha é obrigatório")
    private String senha;

    @Column(nullable = false, length = 100)
    private String login;

    @Email
    @Column(nullable = false, length = 100, unique = true)
    @NotBlank(message = "O campo email é obrigatório")
    private String email;

    @Column(length = 11, unique = true)
    private String telefone;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "O campo instituicao é obrigatório")
    private String instituicao;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id", nullable = false)
    private TipoUsuarioEntity tipoUsuario;

    @JoinColumn(name = "imagem_perfil_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private ImagemPerfil imagemPerfil;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(tipoUsuario.getTipo().name()));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}