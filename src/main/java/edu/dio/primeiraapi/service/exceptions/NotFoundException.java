package edu.dio.primeiraapi.service.exceptions;

public class NotFoundException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super("Resource not found");
    }

}
