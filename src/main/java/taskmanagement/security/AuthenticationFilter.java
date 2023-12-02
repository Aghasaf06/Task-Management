package taskmanagement.security;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import taskmanagement.constants.SecurityConstant;
import taskmanagement.errors.ErrorResponse;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    private final SecurityConstant securityConstants;
    private final JWTProvider jwtProvider;
    private final MyUserDetailsService myUserDetailsService;
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && !authHeader.isEmpty()) {
            if (authHeader.startsWith("Bearer ")) {
                String jwtToken = authHeader.substring(7);
                if (jwtToken.isBlank()) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Bad bearer authentication");
                }
                if (jwtToken.length() > 30) {
                    try {
                        String username  = jwtProvider.extractUserId(jwtToken);
                        UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
                        if (SecurityContextHolder.getContext().getAuthentication() == null) {
                            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
                            SecurityContextHolder.getContext().setAuthentication(token);
                        }
                    } catch (JWTVerificationException ex) {
                        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED, "Provide valid Basic authentication header");
                        response.setStatus(401);
                        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
                        return;
                    }
                }
            }
        }

        doFilter(request, response, filterChain);
    }
}