package app.java.exception;

public class DataEmptyException extends Exception {
    private String objectError;

    public DataEmptyException (String objectError) {
        this.objectError = objectError;
    }

    public String getObjectError() {
        return objectError;
    }

    public void setObjectError(String objectError) {
        this.objectError = objectError;
    }
}
