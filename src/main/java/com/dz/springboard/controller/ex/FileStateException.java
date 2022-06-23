package com.dz.springboard.controller.ex;

public class FileStateException extends FileUploadException{
    /**
     *
     */
    public FileStateException() {
        super();
    }

    /**
     * @param message
     */
    public FileStateException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public FileStateException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public FileStateException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    protected FileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
