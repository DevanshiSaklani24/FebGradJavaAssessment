package com.brew.brewery;

public class BeerException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public BeerException(String message){
        super(message);
    }

    public BeerException(String message, Throwable throwable){
        super(message,throwable);
    }
}