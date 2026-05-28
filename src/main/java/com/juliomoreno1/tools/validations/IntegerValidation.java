package com.juliomoreno1.tools.validations;

import java.util.ArrayList;
import java.util.List;

import com.juliomoreno1.tools.exceptions.ToolException;
import com.juliomoreno1.tools.result.Message;
import com.juliomoreno1.tools.result.MessageLevel;

public class IntegerValidation {

    private final String fieldName;
    private final Integer value;

    private final Integer min;
    private final Integer max;
    private final boolean notNull;
    private final Integer greaterThan;

    private IntegerValidation(Builder builder) {
        this.fieldName = builder.fieldName;
        this.value = builder.value;
        this.min = builder.min;
        this.max = builder.max;
        this.notNull = builder.notNull;
        this.greaterThan = builder.greaterThan;
    }

    public List<Message> validate() {

        List<Message> messages = new ArrayList<>();

        if (fieldName == null || "".equalsIgnoreCase(fieldName)) {
            throw new ToolException("El validador necesita el nombre de la propiedad");
        }

        String title = fieldName.toUpperCase();

        if (notNull && value == null) {
            messages.add(new Message(MessageLevel.ERROR, title, fieldName + " no puede ser vacío"));
            return messages;
        }

        if (greaterThan != null && value.compareTo(greaterThan) <= 0) {
            messages.add(new Message(MessageLevel.WARNING, title, fieldName + " debe ser mayor que " + greaterThan));
        }

        if (min != null && value.compareTo(min) < 0) {
            messages.add(new Message(MessageLevel.WARNING, title, fieldName + " debe ser mayor o igual que " + min));
        }

        if (max != null && value.compareTo(max) > 0) {
            messages.add(new Message(MessageLevel.WARNING, title, fieldName + " debe ser menor o igual que " + max));
        }

        if (messages.isEmpty()) {
            messages.add(new Message(MessageLevel.SUCCESS, title, fieldName + " cumple con todos los parametros de validación"));
        }

        return messages;
    }

    public static class Builder {

        private final String fieldName;
        private final Integer value;

        private Integer min;
        private Integer max;
        private boolean notNull;
        private Integer greaterThan;

        public Builder(String fieldName, Integer value) {
            this.fieldName = fieldName;
            this.value = value;
        }

        public Builder notNull() {
            this.notNull = true;
            return this;
        }

        public Builder greaterThan(Integer value) {
            this.greaterThan = value;
            return this;
        }

        public Builder min(Integer value) {
            this.min = value;
            return this;
        }

        public Builder max(Integer value) {
            this.max = value;
            return this;
        }

        public IntegerValidation build() {
            return new IntegerValidation(this);
        }
    }

    public static Builder of(String fieldName, Integer value) {
        return new Builder(fieldName, value);
    }
}
