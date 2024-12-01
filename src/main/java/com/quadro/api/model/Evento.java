package com.quadro.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Table(name = "eventos")
@Entity
@Data
@NoArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo titulo é obrigatório")
    private String titulo;

    @NotBlank(message = "O campo descricao é obrigatório")
    private String descricao;
    @NotNull(message = "O campo data é obrigatório")
    private LocalDate data;
    @NotNull(message = "O campo id do usúario é obrigatório")
    private Long usuarioId;

    public Evento( String titulo,  LocalDate data,  String descricao,Long usuarioId) {
        this.titulo = titulo;
        this.data = data;
        this.descricao = descricao;
        this.usuarioId = usuarioId;
    }
}
