package app.java.exception;

public class DataExistsException extends Exception {
    private String objectError;

    public DataExistsException(String objectError) {
        this.objectError = objectError;
    }

    public String getObjectError() {
        return objectError;
    }

    public void setObjectError(String objectError) {
        this.objectError = objectError;
    }

}
