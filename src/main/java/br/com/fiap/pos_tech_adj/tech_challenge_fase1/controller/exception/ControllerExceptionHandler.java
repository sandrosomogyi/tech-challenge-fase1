package br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    private StandardError standardError = new StandardError();

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound (
            ControllerNotFoundException controllerNotFoundException,
            HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        standardError.setTimeStamp(Instant.now());
        standardError.setStatus(status.value());
        standardError.setError("Entity not found");
        standardError.setMessage(controllerNotFoundException.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(this.standardError);
    }
}
