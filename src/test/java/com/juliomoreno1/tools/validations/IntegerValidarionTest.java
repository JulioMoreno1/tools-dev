package com.juliomoreno1.tools.validations;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.juliomoreno1.tools.result.Message;
import com.juliomoreno1.tools.result.MessageLevel;

public class IntegerValidarionTest {

    @Test
    public void donotHaveMessage() {
        String campo = "Edad";
        Integer edad = 21;

        Integer edadMinima = 18;
        Integer edadMaxima = 120;
        IntegerValidation validator = IntegerValidation.of(campo, edad)
                .notNull()
                .min(edadMinima)
                .max(edadMaxima)
                .build();

        List<Message> messages = validator.validate();

        assertEquals("Edad cumple con todos los parametros de validación", messages.get(0).getBody());
        ;
    }

    @Test
    public void fieldIsNull() {

        String campo = "Número de días";
        Integer numeroDias = null;

        Integer maximoNumeroDias = 30;
        IntegerValidation validator = IntegerValidation.of(campo, numeroDias)
                .notNull()
                .greaterThan(maximoNumeroDias)
                .build();

        List<Message> messages = validator.validate();

        assertEquals("Número de días no puede ser vacío", messages.get(0).getBody());
    }

    @Test
    public void twoWarnings() {

        String campo = "Cantidad de padres";
        Integer cantidadDePadres = -2;

        IntegerValidation validator = IntegerValidation.of(campo, cantidadDePadres)
                .notNull()
                .greaterThan(-1)
                .min(0)
                .max(2)
                .build();

        List<Message> messages = validator.validate();

        assertEquals(2, messages.size());
        assertEquals(MessageLevel.WARNING, messages.get(0).getLevel());
        assertEquals(MessageLevel.WARNING, messages.get(1).getLevel());
    }
}
