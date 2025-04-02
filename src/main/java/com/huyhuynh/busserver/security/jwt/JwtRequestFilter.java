package com.huyhuynh.busserver.security.jwt;

import com.huyhuynh.busserver.services.AccountInfoService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final AccountInfoService accountInfoService;

    public JwtRequestFilter(JwtUtil jwtUtil, AccountInfoService accountInfoService) {
        this.jwtUtil = jwtUtil;
        this.accountInfoService = accountInfoService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        final String authorizationHeaderToken = request.getHeader("TOKEN");
        if(authorizationHeaderToken!=null) {
            String username = null;
            String jwt = null;
            jwt = authorizationHeaderToken;
            username = jwtUtil.extractUsername(jwt);
            _checkUserName(request, username, jwt);
        } else {

            String username = null;
            String jwt = null;

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwt = authorizationHeader.substring(7);
                username = jwtUtil.extractUsername(jwt);
            }

            _checkUserName(request, username, jwt);
        }
        chain.doFilter(request, response);
    }

    private void _checkUserName(HttpServletRequest request, String username, String jwt) {
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = accountInfoService.loadUserByUsername(username);

            if (jwtUtil.validateToken(jwt)) {
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
    }
}
