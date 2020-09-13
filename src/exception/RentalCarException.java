package exception;

public class RentalCarException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RentalCarException() {
    }

    public RentalCarException(String message) {
        super(message);
    }
}
