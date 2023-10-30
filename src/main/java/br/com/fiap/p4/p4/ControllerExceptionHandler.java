package br.com.fiap.p4.p4;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    private StandardError err = new StandardError();

    @ExceptionHandler(ControllerNotFoundException.class)    
    public ResponseEntity<StandardError> entityNotFound(
        ControllerNotFoundException e, 
        HttpServletRequest resquest) {

            HttpStatus status = HttpStatus.NOT_FOUND;
            err.setTimestamp(Instant.now());
            err.setStatus(status.value());
            err.setError("Entity not found");
            err.setMessage(e.getMessage());
            err.setPath(resquest.getRequestURI());
            return ResponseEntity.status(status).body(this.err);
        }
}