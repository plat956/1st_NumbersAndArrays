package by.latushko.training.exception;

public class IntArrayParseException extends Exception{
    public IntArrayParseException() {
        super();
    }

    public IntArrayParseException(String message) {
        super(message);
    }

    public IntArrayParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntArrayParseException(Throwable cause) {
        super(cause);
    }
}
