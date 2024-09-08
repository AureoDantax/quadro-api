package com.quadro.api.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.quadro.api.config.security.TokenService;
import com.quadro.api.dto.AuthRequestDTO;
import com.quadro.api.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    @JsonFormat
    public ResponseEntity authenticate(@RequestBody @Valid AuthRequestDTO request) {
        var token = new UsernamePasswordAuthenticationToken(request.login(), request.senha());
        var authenticated = authenticationManager.authenticate(token);
        return ResponseEntity.ok(tokenService.generateToken((Usuario) authenticated.getPrincipal()));
    }
}
