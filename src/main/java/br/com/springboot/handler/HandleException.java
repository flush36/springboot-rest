package br.com.springboot.handler;

import br.com.springboot.Error.Builder;
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

                 Builder builderDetail =
                 Builder.ResourceNotFoundDetailsBuilder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail((ex.getMessage()))
                .developermessage(ex.getClass().getName())
                .build();

                 return new ResponseEntity<>(builderDetail, HttpStatus.NOT_FOUND);
    }
}
