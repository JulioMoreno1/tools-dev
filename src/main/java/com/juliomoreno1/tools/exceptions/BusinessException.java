package com.juliomoreno1.tools.exceptions;

/**
 * BusinessException es util cuando el sistema no puede completar una operación de negocio. Por ejempo, 
 * cuando un caso de uso, proceso o acción de negocio no puede ejecutarse. Representa los errores 
 * funcionales asociados al flujo de negocio.
 */
public class BusinessException extends ToolException{

    private final String code;


    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
