package com.quadro.api.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.quadro.api.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String generateToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return JWT.create()
                    .withIssuer("Quadro-api")
                    .withSubject(usuario.getLogin())
                    .withClaim("role",usuario.getTipoUsuario().toString())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Houve um problema ao gerar o token", exception);
        }
    }
}