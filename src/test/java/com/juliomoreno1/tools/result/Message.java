package com.juliomoreno1.tools.result;

import com.juliomoreno1.tools.exceptions.ValidationException;

/**
 * Representa un mensaje generado como resultado
 * de la ejecución de un proceso u operación.
 */
public final class Message {

    private final MessageLevel level;
    private final String title;
    private final String body;

    public Message(MessageLevel level, String title, String body) {
        if (level == null) {
            throw new ValidationException("El nivel del mensaje no puede ser vacío.");
        }

        if (title == null || title.trim().isEmpty()) {
            throw new ValidationException("El titulo del mensaje no puede estar vacío.");
        }

        this.level = level;
        this.title = title;
        this.body = (body == null || body.trim().isEmpty()) ? null : body.trim();
    }

    public MessageLevel getLevel() {
        return level;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Message))
            return false;
        Message m = (Message) o;
        return level == m.level &&
                title.equals(m.title) &&
                ((body == null && m.body == null) || (body != null && body.equals(m.body)));
    }

    @Override
    public int hashCode() {
        int result = level.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "[" + level + "] " + title + (body != null ? ": " + body : "");
    }
}
