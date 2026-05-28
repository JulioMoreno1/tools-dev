package com.juliomoreno1.tools.result;

import java.util.ArrayList;
import java.util.List;

import com.juliomoreno1.tools.exceptions.ToolException;

/**
 * Builder para crear instancias de OperationResult
 * mediante una API fluida.
 *
 * Permite configurar el estado de la operación, mensajes,
 * cantidad de elementos afectados y datos asociados antes
 * de generar el resultado final.
 */
public class ResultBuilder <T> {

    private boolean success;
    private List<Message> messages = new ArrayList<>();
    private int affectedCount;
    private T data;

    private ResultBuilder(boolean success){
        this.success = success;
    }

    public static <T> ResultBuilder<T> succes() {
        return new ResultBuilder<>(true);
    }

    public static <T> ResultBuilder<T> failure() {
        return new ResultBuilder<>(false);
    }

    public ResultBuilder<T> message (Message message) {
        if (message == null) {
            throw new ToolException("El mensaje no puede estar vacío");
        }
        this.messages.add(message);
        return this;
    }

    public ResultBuilder<T> affectedCount(int count) {
        if (count < 0) {
            throw new ToolException("Los elementos afectados no puede ser negativo");
        }
        this.affectedCount = count;
        return this;
    }

    public ResultBuilder<T> data(T data) {
        this.data = data;
        return this;
    }

    public OperationResult<T> build() {
        return new OperationResult<>(success, messages, affectedCount, data);
    }
}
