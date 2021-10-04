package exception;

public class InputFileReadingException extends Exception{
    public InputFileReadingException(String message) {
        super(message);
    }

    public InputFileReadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
