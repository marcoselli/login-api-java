package br.com.devmarco.kyroschallenge.controllers.token;

import br.com.devmarco.kyroschallenge.security.JWTAuthenticationFilter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTToken {
    public static String decodeToken(String token){
        token = token.replace("Bearer ", "");

        return JWT.require(Algorithm.HMAC512(JWTAuthenticationFilter.TOKEN_PASSWORD))
                .build()
                .verify(token)
                .getSubject();
    }
}
