package br.com.devmarco.kyroschallenge.service.exceptions;

import lombok.Data;

@Data
public class UserException extends Exception{
    
    public UserException(String message) {
        super(message);
    }
}
