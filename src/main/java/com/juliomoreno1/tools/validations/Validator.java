package com.juliomoreno1.tools.validations;

import java.util.List;

import com.juliomoreno1.tools.result.Message;

public interface Validator {
    List<Message> validate();
}
