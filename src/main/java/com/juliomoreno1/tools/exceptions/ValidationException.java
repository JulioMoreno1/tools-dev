package com.juliomoreno1.tools.exceptions;

/**
 * ValidationException se utiliza para gestionar errores relacionados con la validación 
 * de datos, ya sean datos introducidos por el usuario o valores definidos por el desarrollador.
 */
public class ValidationException extends ToolException{

    private final String field;

    private final String code;

    public ValidationException(String field, String code, String message) {
        super(message);
        this.field = field;
        this.code = code;
    }

    public ValidationException(String field, String code, String message, Throwable cause) {
        super(message, cause);
        this.field = field;
        this.code = code;
    }

    public String getField() {
        return field;
    }

    public String getCode() {
        return code;
    }

}
