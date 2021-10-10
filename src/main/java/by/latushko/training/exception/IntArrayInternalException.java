package by.latushko.training.exception;

public class IntArrayInternalException extends Exception{
    public IntArrayInternalException() {
        super();
    }

    public IntArrayInternalException(String message) {
        super(message);
    }

    public IntArrayInternalException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntArrayInternalException(Throwable cause) {
        super(cause);
    }
}
