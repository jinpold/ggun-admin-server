package com.james.api.common.exception;
import com.james.api.common.component.security.JwtProvider;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class JwtExceptionHandler {
    public static JwtProvider jwt;

    @GetMapping("/exception")
    @ExceptionHandler(ExpiredJwtException.class)
    public String ReAccessToken (){
        return "access token expired";
    }
}