package com.vacunapp2.vacunapp.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class Autorizacion implements Filter{
    public static final String KEY="turvknoiuggcxt85rsteshtfcp";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
                HttpServletRequest req = (HttpServletRequest) request;

                String url = req.getRequestURI();
                
                if(url.contains("/usuarios") || url.contains("/usuarios/login") || url.contains("/pacientes")){
                    chain.doFilter(request, response);
                }else{
                    String hash = req.getHeader("Authorization");
                    if(hash == null || hash.trim().equals("")){
                        response.setContentType("application/json");
                        String body = "{\"autorizacion\":\"No autorizado\"}";
                        response.getWriter().write(body);
                    }try{
                        Jws<Claims> claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(hash);
                        if(url.contains("/laboratorios") && !claims.getBody().get("username").equals("")){
                            chain.doFilter(request, response);
                        }
                    }catch(MalformedJwtException e){
                        response.setContentType("application/json");
                        String body = "{\"autorizacion\":\"Token no válido\"}";
                        response.getWriter().write(body);
                    }
                }
    }
}
