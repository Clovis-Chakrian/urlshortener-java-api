package br.com.clovischakrian.urlshortener.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> badRequestExceptionHandler(Exception exception) {
        if (!(exception instanceof MethodArgumentNotValidException)) {
            return ResponseEntity.internalServerError().body("Ouve um erro da aplicação - " + exception.getMessage() + " - Tipo do Erro: " + exception.getClass());
        }

        return ResponseEntity.badRequest().body("Erros de validação - " + exception.getMessage());
    }
}
