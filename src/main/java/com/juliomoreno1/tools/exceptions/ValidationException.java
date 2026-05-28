package com.juliomoreno1.tools.exceptions;

/**
 * ValidationException se utiliza para gestionar errores relacionados con la validación 
 * de datos, ya sean datos introducidos por el usuario o valores definidos por el desarrollador.
 */
public class ValidationException extends ToolException{

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

}
