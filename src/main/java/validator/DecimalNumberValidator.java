package validator;

public class DecimalNumberValidator {
    private static final String DECIMAL_PATTERN = "^[-+]?\\d*[.]?\\d+|^[-+]?\\d+[.]?\\d*";

    public boolean validate(String numberString) {
        return numberString != null ? numberString.matches(DECIMAL_PATTERN) : false;
    }
}
