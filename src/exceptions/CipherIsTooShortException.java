package exceptions;

public class CipherIsTooShortException extends Exception {
    public CipherIsTooShortException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
