package com.turkcell.northwind2.core.utilities.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtAuthService {
    public static String SECRET_KEY="oyB7uI3wL/no+GjZ2p5TRdPp/f6Hx6pBGyoBix12MQ+SjpJmHkFoZLANDWmlMdFORND0clCxgM1YOpY0LuFWv9lN+I9YiHMzjRxG3qzsawZDCWqB1gclUMsWtlczSEmCVKmun38Jwda3uALYWZUnDSb8Q4C+nkI9kpPunXXxCblzYgCdFgEwnive9PmdDRKsxJPjV6udMpNNYUE7KjYXHRI3EF3UqwqBLarRCCUO8SP7zqHLNOaq3tfon8exgcgF7lPHQDRQwf6D3IRk0gaK2+/MbVK/fyQr88zw5M8e0GaGaeHZuubdx8OgfUk0E8FOwp5NzcERNTbS2JT1jbdTTASPtuo+pcQms7hf8tV4K1c=\n";
    public String extractUserName(String token){
        return exportClaim(token,Claims::getSubject);
    }
    public boolean isValidToken(String token,UserDetails user){
        final String username=extractUserName(token);
        return (user.getUsername().equals(username) && !expiredToken(token));
    }
    public boolean expiredToken(String token){
        return extractExpired(token).before(new Date());
    }
    public Date extractExpired(String token){
        return exportClaim(token,Claims::getExpiration);
    }
    public <T> T exportClaim(String token, Function<Claims,T>resolverClaims){
        final Claims claims=extractGetAllClaims(token);
        return resolverClaims.apply(claims);
    }

    public Claims extractGetAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSigninKey()).build().parseClaimsJws(token).getBody();
    }
    public Key getSigninKey(){
        byte[] key= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(key);
    }
    public String generatedToken(UserDetails user){
        return Jwts.builder().setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
