package exception;

public class IntArrayCastingException extends Exception{
    public IntArrayCastingException(String message) {
        super(message);
    }

    public IntArrayCastingException(String message, Throwable cause) {
        super(message, cause);
    }
}
