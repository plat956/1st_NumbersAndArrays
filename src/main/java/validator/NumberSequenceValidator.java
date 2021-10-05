package validator;

public class NumberSequenceValidator {
    private static final String SEQUENCE_PATTERN = "^-?\\d+(\\s(-?\\d+))*$";

    public boolean validate(String inputString) {
        return inputString != null ? inputString.matches(SEQUENCE_PATTERN) : false;
    }
}
