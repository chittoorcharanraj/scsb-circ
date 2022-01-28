package org.extensiblecatalog.ncip.v2.service;

public class ServiceException extends Exception {
    private final ServiceError error;

    public ServiceException(ServiceError error, String explanation, Throwable cause) {
        super(explanation, cause);
        this.error = error;
    }

    public ServiceException(ServiceError error, String explanation) {
        super(explanation);
        this.error = error;
    }

    public ServiceException(ServiceError error, Throwable cause) {
        super(cause);
        this.error = error;
    }

    public ServiceError getError() {
        return this.error;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Service error: ").append(this.error).append(". ").append(super.toString());
        return buffer.toString();
    }
}
