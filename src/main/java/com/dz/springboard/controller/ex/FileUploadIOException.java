package com.dz.springboard.controller.ex;

public class FileUploadIOException extends FileUploadException{
    /**
     *
     */
    public FileUploadIOException() {
        super();
    }

    /**
     * @param message
     */
    public FileUploadIOException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public FileUploadIOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public FileUploadIOException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    protected FileUploadIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
