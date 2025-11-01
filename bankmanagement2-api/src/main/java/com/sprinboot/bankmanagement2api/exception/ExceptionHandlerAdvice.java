package com.sprinboot.bankmanagement2api.exception;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.LocalDateTime;
import java.time.LocalTime;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(BankDetailsNotFound.class)
    public ResponseEntity<ExceptionResponse> handlePublicException(BankDetailsNotFound ex, HttpServletRequest request) {

        ExceptionResponse exceptionResponse = buildException("BANK NOT FOUND", ex.getMessage(), request.getRequestURI(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }


    public ExceptionResponse buildException(String errorCode, String errorMessage, String requestURI, HttpStatus status) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setErrorCode(errorCode);
        exceptionResponse.setErrorMessage(errorMessage);
        exceptionResponse.setRequestURI(requestURI);
        exceptionResponse.setStatus(status.value());
        exceptionResponse.setTimestamp(LocalDateTime.now());

        return exceptionResponse;
    }

}


