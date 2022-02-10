package com.mohmolloris.dadaya.exeptions;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<ExceptionsDto> handleIllegalArgumentException(IllegalArgumentException exception) {
        HttpHeaders map = new HttpHeaders(){{
            add("zavupa","konskaya");
        }};
        ExceptionsDto exceptionsDto = new ExceptionsDto("реквест говно, соси письку!");
        return new ResponseEntity<ExceptionsDto>(exceptionsDto, map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value
            = {InvalidDefinitionException.class})
    public ResponseEntity<Object> handleInvalidDefinitionException(InvalidDefinitionException invalidDefinitionException) {
        return ResponseEntity.badRequest().build();
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
    }
}
