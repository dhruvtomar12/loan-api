package com.example.loan_api.Exception;

public class ExternalApiException extends RuntimeException{
    public ExternalApiException(String message){
        super(message);
    }
}
