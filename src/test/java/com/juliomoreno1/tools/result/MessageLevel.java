package com.juliomoreno1.tools.result;

/**
 * Representa la severidad o categoría de un mensaje
 * generado durante la ejecución de un proceso.
 */
public enum MessageLevel {

    /**
     * Indica que el proceso finalizó correctamente.
     */
    SUCCESS,

    /**
     * Proporciona información general sobre el proceso.
     */
    INFO,

    /**
     * Indica una advertencia o situación que debe considerarse.
     */
    WARNING,

    /**
     * Indica que ocurrió un error durante el proceso.
     */
    ERROR
}
