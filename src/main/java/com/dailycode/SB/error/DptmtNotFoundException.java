package com.dailycode.SB.error;

public class DptmtNotFoundException extends Exception{
    public DptmtNotFoundException() {
        super();
    }

    public DptmtNotFoundException(String message) {
        super(message);
    }

    public DptmtNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DptmtNotFoundException(Throwable cause) {
        super(cause);
    }

    protected DptmtNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
