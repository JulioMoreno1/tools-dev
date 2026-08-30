package com.juliomoreno1.tools.result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.juliomoreno1.tools.exceptions.ToolException;

/**
 * Representa el resultado de una operación, incluyendo:
 * el estado de éxito, mensajes asociados, cantidad de elementos afectados
 * y datos adicionales relacionados con la operación. 
 */
public final class OperationResult <T> {

    private final boolean success;
    private final List<Message> messages;
    private final int affectedCount;
    private final T data;

    public OperationResult(boolean success, List<Message> messages, int affectedCount, T data) {
        if (messages == null) {
            throw new ToolException("La lista de mensajes no puede estar vacía.");
        }
        
        if (affectedCount < 0) {
            throw new ToolException("La cantidad de elementos afectados no puede ser negativo");
        }

        this.success = success;
        this.messages = Collections.unmodifiableList(new ArrayList<>(messages));
        this.affectedCount = affectedCount;
        this.data = data;
    }

    public boolean isSuccess(){
        return success;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public int getAffectedCount() {
        return affectedCount;
    }

    public T getData() {
        return data;
    }

    public boolean hasErrors() {
        for (Message message : messages) {
            if (message.getLevel() == MessageLevel.ERROR) {
                return true;
            }
        }
        return false;
    }

    public boolean hasWarnings() {
        for (Message message : messages) {
            if (message.getLevel() == MessageLevel.WARNING) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "OperationResult [success=" + success + ", messages=" + messages + ", affectedCount=" + affectedCount
                + "]";
    }

}
