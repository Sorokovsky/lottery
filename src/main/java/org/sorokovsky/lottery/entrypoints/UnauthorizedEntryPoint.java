package org.sorokovsky.lottery.entrypoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.sorokovsky.lottery.contract.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setHeader(HttpHeaders.WWW_AUTHENTICATE, "Bearer");
        var mapper = new ObjectMapper();
        var apiError = new ApiError("Unauthorized", HttpStatus.UNAUTHORIZED.value());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, mapper.writeValueAsString(apiError));
    }
}
