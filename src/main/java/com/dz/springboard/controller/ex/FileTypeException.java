package com.dz.springboard.controller.ex;

public class FileTypeException extends FileUploadException{
    /**
     *
     */
    public FileTypeException() {
        super();
    }

    /**
     * @param message
     */
    public FileTypeException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public FileTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public FileTypeException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    protected FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
