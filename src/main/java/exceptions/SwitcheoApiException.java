package exceptions;

public class SwitcheoApiException extends RuntimeException{

    private SwitcheoApiError error;

    public SwitcheoApiException(SwitcheoApiError error) {
        this.error = error;
    }

    public SwitcheoApiException() {
        super();
    }

    public SwitcheoApiException(String message) {
        super(message);
    }


    public SwitcheoApiException(Throwable cause) {
        super(cause);
    }

    public SwitcheoApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public SwitcheoApiError getError() {
        return error;
    }
}

