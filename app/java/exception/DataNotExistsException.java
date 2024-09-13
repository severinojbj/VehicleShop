package app.java.exception;

public class DataNotExistsException extends Exception {
    private String objectError;

    public DataNotExistsException(String objectError) {
        this.objectError = objectError;
    }

    public String getObjectError() {
        return objectError;
    }

    public void setObjectError(String objectError) {
        this.objectError = objectError;
    }

}
