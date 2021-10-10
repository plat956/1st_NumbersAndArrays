package by.latushko.training.validator.impl;

import by.latushko.training.validator.CustomValidator;

public class DecimalNumberValidator implements CustomValidator {
    private static final String DECIMAL_PATTERN = "^[-+]?\\d*[.]?\\d+|^[-+]?\\d+[.]?\\d*";

    @Override
    public boolean validate(String inputString) {
        return inputString != null ? inputString.matches(DECIMAL_PATTERN) : false;
    }
}
