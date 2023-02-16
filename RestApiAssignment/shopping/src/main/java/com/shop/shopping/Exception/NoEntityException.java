package com.shop.shopping.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoEntityException extends Exception {
    private int number;
    public int getNumber(){return number;}
    public NoEntityException(Long id, String message){
        super(message);
    }
}