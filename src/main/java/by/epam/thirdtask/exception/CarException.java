package by.epam.thirdtask.exception;

public class CarException extends Exception {
    public CarException() {
    }

    public CarException(String message) {
        super(message);
    }

    public CarException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarException(Throwable cause) {
        super(cause);
    }
}
