package com.roberta.invoicemanagementbackend.exception;

public class GlobalRequestException extends RuntimeException{


    public GlobalRequestException(String message) {
        super(message);
    }

    public GlobalRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
