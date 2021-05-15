package com.ufcg.psoft.projeto_final.web_security;

import com.ufcg.psoft.projeto_final.DTOs.LoginDTO;
import com.ufcg.psoft.projeto_final.entidades.Login;
import com.ufcg.psoft.projeto_final.repository.LoginRepository;
import com.ufcg.psoft.projeto_final.services.LoginResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtTokenService {

    @Autowired
    private LoginRepository userDAO;

    public String getUserEmailFromJWTToken(String token) throws Exception {
        byte[] signingKey = SecurityConstants.JWT_SECRET.getBytes();

        Jws<Claims> parsedToken = Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token.replace("Bearer ", ""));

        String username = parsedToken
                .getBody()
                .getSubject();

        return username;
    }

    // public static final String TOKEN_KEY = "p3swhJQ2rzLbwPIdfmSr2w";
    public static final String TOKEN_KEY = "p3swhJQ2rzLbwPIdfmSr2vuherfr8ty5t5478y4bvr7857tyufvrg7c8g7dscw";


    public LoginResponse autentica(LoginDTO user) {
        String msgErro = "Login e/ou senha invalido(s). Login nao realizado";

        Optional<Login> optUsuario = userDAO.findByLogin(user.getLogin());



        if (optUsuario.isPresent()) {



            if (user.getSenha().equals(optUsuario.get().getSenha())) {


                return new LoginResponse(geraToken(user));
            }

        }

        return new LoginResponse(msgErro);

    }

    private String geraToken(LoginDTO user) {
        String token = Jwts.builder().setSubject(user.getLogin()).signWith(SignatureAlgorithm.HS256, TOKEN_KEY)
                .setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000)).compact();
        return token;
    }
}
