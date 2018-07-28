package exceptions;

public class SwitcheoApiError {

    private int code;
    private String message;

    public SwitcheoApiError(int code, String message){
        this.code = code;
        this.message = message;
    }

    private int getCode(){
        return this.code;
    }

    private String getMessage(){
        return this.message;
    }

    private void setMessage(String message){
        this.message = message;
    }

    private void setCode(){
        this.code = code;
    }
}
