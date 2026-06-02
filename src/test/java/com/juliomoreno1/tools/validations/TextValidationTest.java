package com.juliomoreno1.tools.validations;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.juliomoreno1.tools.result.Message;
import com.juliomoreno1.tools.result.MessageLevel;

public class TextValidationTest {

    @Test
    public void doNotMustBeNull() {

        String campo = "Nombre";
        String nombre = "";

        Integer longitud = 15;

        TextValidation validator = TextValidation.of(campo, nombre)
                .notNull()
                .maxCharacters(longitud)
                .build();

        List<Message> messages = validator.validate();

        assertEquals(MessageLevel.ERROR, messages.get(0).getLevel());
        assertEquals("Nombre no debe ser vacío", messages.get(0).getBody());
    }

    @Test
    public void unlimitedText() {

        String campo = "Dirección";
        String direccion = "Una calle con un cierto número en una cierta localidad de algún país";

        TextValidation validator = TextValidation.of(campo, direccion)
                .notNull()
                .build();

        
        List<Message> messages = validator.validate();

        assertEquals(MessageLevel.SUCCESS, messages.get(0).getLevel());
        assertEquals("Dirección cumple con todas las validaciones", messages.get(0).getBody());
    }
}
