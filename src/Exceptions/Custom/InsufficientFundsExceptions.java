package Exceptions.Custom;

// Checked -> Exception class
// Unchecked (runtime) -> RuntimeException class

public class InsufficientFundsExceptions extends Exception { // because we should recover from the error
    public InsufficientFundsExceptions() {
        super("Insufficient funds in your account.");
    }

    public InsufficientFundsExceptions(String message) {
        super(message);
    }
}
