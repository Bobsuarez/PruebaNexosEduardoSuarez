package com.nexosprueba.pruebaeduardosuarez.config;


import com.nexosprueba.pruebaeduardosuarez.excepcion.AplicacionExcepcion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {


    @ExceptionHandler(AplicacionExcepcion.class)
    public ResponseEntity<?>aplicationException(Exception error){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
    }


}
