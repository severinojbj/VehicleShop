package app.java.exception;

public class EmptyDataException extends Exception {
    private String objectError;

    public EmptyDataException (String objectError) {
        this.objectError = objectError;
    }

    public String getObjectError() {
        return objectError;
    }

    public void setObjectError(String objectError) {
        this.objectError = objectError;
    }

}
