package com.turkcell.northwind2.core.utilities.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtAuthService service;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String header=request.getHeader("Authorization");
        if (header==null || header.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }
        final String jwt=header.substring(7);
        final String username=service.extractUserName(jwt);
        if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails user=userDetailsService.loadUserByUsername(username);
            if (service.isValidToken(jwt,user)){
                UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(token);
            }
        }
        filterChain.doFilter(request,response);
    }
}
