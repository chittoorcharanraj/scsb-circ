package org.extensiblecatalog.ncip.v2.service;

public class ToolkitException extends Exception {
    public ToolkitException(String explanation, Throwable cause) {
        super(explanation, cause);
    }

    public ToolkitException(String explanation) {
        super(explanation);
    }

    public ToolkitException(Throwable cause) {
        super(cause);
    }
}
