package com.dz.springboard.controller.ex;

public class FileEmptyException extends FileUploadException{
    /**
     *
     */
    public FileEmptyException() {
        super();
    }

    /**
     * @param message
     */
    public FileEmptyException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public FileEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public FileEmptyException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    protected FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
