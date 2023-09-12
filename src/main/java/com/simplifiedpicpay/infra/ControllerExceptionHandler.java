package com.simplifiedpicpay.infra;

import com.simplifiedpicpay.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// That annotation is the last layer of Exception, so basically when you
// throw an exception, you need to treat it.
// This annotation is made to check if there is any treatment for the exceptions.

public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity treatDuplicatedEntry(DataIntegrityViolationException exception) {

        ExceptionDTO exceptionDTO = new ExceptionDTO("That user has already been registered", "400");

        return ResponseEntity.badRequest().body(exceptionDTO);

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity treat404(EntityNotFoundException exception) {

        return ResponseEntity.notFound().build();

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity threatGeneralException(Exception exception) {

        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");

        return ResponseEntity.internalServerError().body(exceptionDTO);

    }

}
