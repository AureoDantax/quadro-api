package com.quadro.api.service;

import com.quadro.api.model.Evento;
import com.quadro.api.repository.EventoRepository;
import com.quadro.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class EventoService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EventoRepository eventoRepository;

    public Evento cadastrarEvento(Evento eventoModel) {

        var usuario = usuarioRepository.findById(eventoModel.getUsuarioId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data = LocalDate.parse(eventoModel.getData().toString(), formatter);

        var evento = new Evento(eventoModel.getTitulo(), data, eventoModel.getDescricao(),usuario.getId());
        return eventoRepository.save(evento);
    }
}
