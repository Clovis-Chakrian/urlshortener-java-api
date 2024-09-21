package br.com.clovischakrian.urlshortener.controllers;

import nonapi.io.github.classgraph.json.JSONSerializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> badRequestExceptionHandler(Exception exception) {
        if (!(exception instanceof MethodArgumentNotValidException)) {
            return ResponseEntity.internalServerError().body("Ouve um erro da aplicação - " + exception.getMessage());
        }

        MethodArgumentNotValidException ex = (MethodArgumentNotValidException)exception;

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(new ApiError("Ocorreram erros de validação", errors));
    }
}
