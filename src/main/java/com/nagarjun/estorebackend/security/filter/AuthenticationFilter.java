package com.nagarjun.estorebackend.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarjun.estorebackend.entity.User;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        chain.doFilter(request, response);

    }

    // /login
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

                try {
                    User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
                    System.out.println(user.getUsername());
                    System.out.println(user.getLastName());
                } catch (IOException e){
                    throw new RuntimeException();
                }

        return super.attemptAuthentication(request, response);
    }

    
}
