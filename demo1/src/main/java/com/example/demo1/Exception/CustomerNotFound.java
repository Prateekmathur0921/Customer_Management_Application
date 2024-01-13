package com.example.demo1.Exception;
import org.springframework.http.HttpStatus;
public class CustomerNotFound extends RuntimeException{
    public CustomerNotFound(String message){
        super(message);
    }
}
