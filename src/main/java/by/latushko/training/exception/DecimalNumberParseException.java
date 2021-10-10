package by.latushko.training.exception;

public class DecimalNumberParseException extends Exception{
    public DecimalNumberParseException() {
        super();
    }

    public DecimalNumberParseException(String message) {
        super(message);
    }

    public DecimalNumberParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DecimalNumberParseException(Throwable cause) {
        super(cause);
    }
}
