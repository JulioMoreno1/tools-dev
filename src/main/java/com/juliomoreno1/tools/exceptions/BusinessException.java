package com.juliomoreno1.tools.exceptions;

/**
 * BusinessException es util cuando el sistema no puede completar una operación de negocio. Por ejempo, 
 * cuando un caso de uso, proceso o acción de negocio no puede ejecutarse. Representa los errores 
 * funcionales asociados al flujo de negocio.
 */
public class BusinessException extends ToolException{

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}
