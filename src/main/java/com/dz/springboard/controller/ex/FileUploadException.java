package com.dz.springboard.controller.ex;

public class FileUploadException extends RuntimeException{
    /**
     *
     */
    public FileUploadException() {
        super();
    }

    /**
     * @param message
     */
    public FileUploadException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public FileUploadException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    protected FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
