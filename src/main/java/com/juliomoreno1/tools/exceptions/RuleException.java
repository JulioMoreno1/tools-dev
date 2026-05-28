package com.juliomoreno1.tools.exceptions;

/**
 * RuleException es útil si existe una regla del dominio que fue violada. Se usa cuando una validación 
 * de dominio impide continuar. Por lo tanto, representa violaciones explícitas de reglas 
 * de negocio o invariantes.
 */
public class RuleException extends BusinessException {

    public RuleException(String message) {
        super(message);
    }

    public RuleException(String message, Throwable cause) {
        super(message, cause);
    }
}
