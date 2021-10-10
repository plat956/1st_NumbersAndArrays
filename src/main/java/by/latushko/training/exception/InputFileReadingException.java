package by.latushko.training.exception;

public class InputFileReadingException extends Exception{
    public InputFileReadingException() {
        super();
    }

    public InputFileReadingException(String message) {
        super(message);
    }

    public InputFileReadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputFileReadingException(Throwable cause) {
        super(cause);
    }
}
