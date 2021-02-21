package com.nunu.lmc.Entity;

public class ErrorException extends Throwable {
    String errorCode;
    String errorMessage;

    public ErrorException() {
    }

    public ErrorException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getFullErrorMessage() {
        return this.errorCode + "-"+ this.errorMessage;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ErrorException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
