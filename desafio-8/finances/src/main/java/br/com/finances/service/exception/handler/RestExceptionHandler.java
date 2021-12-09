package br.com.finances.service.exception.handler;

import br.com.finances.service.exception.DivisionByZeroException;
import br.com.finances.service.exception.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(DivisionByZeroException.class)
    public ResponseEntity<?> DivisionByZeroException(DivisionByZeroException divisionByZeroException){
       ExceptionDetails details = ExceptionDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Erro aritmético")
                .detail(divisionByZeroException.getMessage())
                .developerMessage(divisionByZeroException.getClass().getName())
                .build();
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }
}
