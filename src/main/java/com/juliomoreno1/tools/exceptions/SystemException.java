package com.juliomoreno1.tools.exceptions;

/**
 * SystemException se utiliza para gestionar errores internos del sistema, incluyendo fallos en 
 * conexiones a bases de datos, procesamiento y manipulación de datos, comunicaciones de red, 
 * interacción con sistemas externos y operaciones sobre ficheros o directorios.
 */
public class SystemException extends ToolException {

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
