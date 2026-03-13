package com.example.u3holamundo.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> manejarValidacion(
        MethodArgumentNotValidException ex
    ){
        Map<String,String> errores = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(e ->
                    errores.put(
                            e.getField(),
                            e.getDefaultMessage()));
                    return errores;
    }
}
