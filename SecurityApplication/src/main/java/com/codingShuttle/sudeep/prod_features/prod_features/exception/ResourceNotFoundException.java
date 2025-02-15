package com.codingShuttle.sudeep.prod_features.prod_features.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
