package com.juliomoreno1.tools.validations;

import java.util.ArrayList;
import java.util.List;

import com.juliomoreno1.tools.exceptions.ToolException;
import com.juliomoreno1.tools.result.Message;
import com.juliomoreno1.tools.result.MessageLevel;

public class TextValidation implements Validator {

    private final String fieldName;
    private final String text;

    private final Integer max;
    private final boolean notNull;

    private TextValidation(Builder builder) {
        this.fieldName = builder.fieldName;
        this.text = builder.text;
        this.notNull = builder.notNull;
        this.max = builder.max;
    }

    @Override
    public List<Message> validate() {

        List<Message> messages = new ArrayList<>();

        if (fieldName == null || fieldName.isBlank()) {
            throw new ToolException("El validador necesita el nombre de la propiedad");
        }

        String title = fieldName.toUpperCase();

        if (notNull && (text == null || text.isBlank())) {
            messages.add(new Message(MessageLevel.ERROR, title, fieldName + " no debe ser vacío"));
            return messages;
        }

        if (max != null && text != null && text.length() > max) {
            messages.add(new Message(MessageLevel.WARNING, title, fieldName + " no debe superar los " + max + " caracteres"));
        }

        if (messages.isEmpty()) {
            messages.add(new Message(MessageLevel.SUCCESS, title, fieldName + " cumple con todas las validaciones"));
        }
        
        return messages;
    }

    public static class Builder {

        private final String fieldName;
        private final String text;

        private Integer max;
        private boolean notNull;

        public Builder(String fieldName, String text) {
            this.fieldName = fieldName;
            this.text = text;
        }

        public Builder notNull() {
            this.notNull = true;
            return this;
        }

        public Builder maxCharacters(int max) {
            this.max = max;
            return this;
        }

        public TextValidation build() {
            return new TextValidation(this);
        }
    }

    public static  Builder of(String fieldName, String value) {
        return new Builder(fieldName, value);
    }

}
