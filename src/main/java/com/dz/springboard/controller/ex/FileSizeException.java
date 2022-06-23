package com.dz.springboard.controller.ex;

public class FileSizeException extends FileUploadException{
    /**
     *
     */
    public FileSizeException() {
        super();
    }

    /**
     * @param message
     */
    public FileSizeException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public FileSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public FileSizeException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    protected FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
