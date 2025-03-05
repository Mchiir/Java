package Exceptions.Custom;

public class AccountException extends Exception {
    public AccountException(Exception cause) {
        super(cause);
    }
}
