package br.com.springboot.handler;

import br.com.springboot.Error.ResourceNotFoundDetails;
import br.com.springboot.Error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class HandleException {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException ex) {
    	
                 ResourceNotFoundDetails build = ResourceNotFoundDetails.Builder
                 .newBuilder()
                 .timestamp(new Date().getTime())
                 .status(HttpStatus.NOT_FOUND.value())
                 .title("Resource not found")
                 .detail(ex.getMessage())
                 .developerMessage(ex.getClass().getName())
                 .build();

                 return new ResponseEntity<>(build, HttpStatus.NOT_FOUND);
    }
}
