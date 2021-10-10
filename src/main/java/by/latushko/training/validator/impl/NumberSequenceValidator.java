package by.latushko.training.validator.impl;

import by.latushko.training.validator.CustomValidator;

public class NumberSequenceValidator implements CustomValidator {
    private static final String SEQUENCE_PATTERN = "^-?\\d+(\\s(-?\\d+))*$";

    @Override
    public boolean validate(String inputString) {
        return inputString != null ? inputString.matches(SEQUENCE_PATTERN) : false;
    }
}
