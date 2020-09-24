package eldar.datarestdemo.events.exceptions;

public class AlreadyCheckedInException extends RuntimeException {

    private String message;

    public AlreadyCheckedInException(String message) {
        super(message);
    }
}
