package exceptions;

public class NotEnoughCharactersException extends Exception {
    public NotEnoughCharactersException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
