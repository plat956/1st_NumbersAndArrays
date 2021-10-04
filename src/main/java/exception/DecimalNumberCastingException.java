package exception;

public class DecimalNumberCastingException extends Exception{
    public DecimalNumberCastingException(String message) {
        super(message);
    }

    public DecimalNumberCastingException(String message, Throwable cause) {
        super(message, cause);
    }
}
