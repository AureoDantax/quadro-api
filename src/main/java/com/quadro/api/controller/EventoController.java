package com.quadro.api.controller;

import com.quadro.api.model.Evento;
import com.quadro.api.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("api/eventos")
@CrossOrigin("*")
public class EventoController {
    @Autowired
    EventoService eventoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Evento> cadastrarEvento(@Valid @RequestBody Evento evento) {
        var eventoEntity = eventoService.cadastrarEvento(evento);
        return created(null).body(eventoEntity);
    }
}
