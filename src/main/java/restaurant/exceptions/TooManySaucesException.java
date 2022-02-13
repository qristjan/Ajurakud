package restaurant.exceptions;

public class TooManySaucesException extends Exception {

    private final String message;

    public TooManySaucesException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
