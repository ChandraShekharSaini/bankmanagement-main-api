package com.sprinboot.bankmanagement2api.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class ExceptionResponse {

    private String errorCode;
    private String errorMessage;
    private String requestURI;
    private int status;

    @JsonFormat(shape = JsonFormat.Shape.STRING )
    private LocalDateTime timestamp;
}
