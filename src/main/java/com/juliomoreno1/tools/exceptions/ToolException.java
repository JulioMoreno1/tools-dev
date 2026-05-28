package com.juliomoreno1.tools.exceptions;

/**
 * ToolExcepción permite lanzar excepciones asociadas al funcionamiento del kit de herramientas. 
 * Además, puede utilizarse de forma externa al proyecto para manejar errores en operaciones 
 * comunes de programación, como conversiones, transformaciones o formateo de objetos.
 */
public class ToolException extends RuntimeException {

    public ToolException(String message) {
        super(message);
    }   
    
    public ToolException(String message, Throwable cause) {
        super(message, cause);
    }
}