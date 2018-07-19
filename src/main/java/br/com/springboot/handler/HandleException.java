package br.com.springboot.handler;

import br.com.springboot.Error.ResourceNotFoundDetails;
import br.com.springboot.Error.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Builder {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException ex) {

    }
}
