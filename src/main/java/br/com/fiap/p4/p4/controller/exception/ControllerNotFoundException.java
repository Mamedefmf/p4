package br.com.fiap.p4.p4.controller.exception;

public class ControllerNotFoundException extends RuntimeException{
    public ControllerNotFoundException(String message){
        super(message);
    }
}
