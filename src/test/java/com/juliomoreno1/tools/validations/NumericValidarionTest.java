package com.juliomoreno1.tools.validations;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.juliomoreno1.tools.result.Message;
import com.juliomoreno1.tools.result.MessageLevel;


public class NumericValidarionTest {

    @Test
    public void donotHaveMessageLong() {
        String campo = "Edad";
        Long edad = 21L;

        Long edadMinima = 18L;
        Long edadMaxima = 120L;
        NumericValidation<Long> validator = NumericValidation.of(campo, edad)
                .notNull()
                .min(edadMinima)
                .max(edadMaxima)
                .build();

        List<Message> messages = validator.validate();

        assertEquals("Edad cumple con todos los parametros de validación", messages.get(0).getBody());
        ;
    }

    @Test
    public void validateSalaryBigDecimal() {

        String campo = "Salario";
        BigDecimal salario = new BigDecimal("8000.00");
        BigDecimal minimo = new BigDecimal("9451.20");

        NumericValidation<BigDecimal> validator = NumericValidation.of(campo, salario)
                .min(minimo)
                .build();

        List<Message> mensajes = validator.validate();

        assertEquals(MessageLevel.WARNING, mensajes.get(0).getLevel());
        assertEquals("Salario debe ser mayor o igual que 9451.20", mensajes.get(0).getBody());
    }

    @Test
    public void validateTurnInteger() {

        String campo = "Número de turno";
        Integer turno = 201;

        Integer maximoDeTurnos = 200;

        NumericValidation<Integer> validator = NumericValidation.of(campo, turno)
        .max(maximoDeTurnos)
        .build();

        List<Message> messages = validator.validate();

        assertEquals(MessageLevel.WARNING, messages.get(0).getLevel());
        assertEquals("Número de turno debe ser menor o igual que 200", messages.get(0).getBody());
    }
}
