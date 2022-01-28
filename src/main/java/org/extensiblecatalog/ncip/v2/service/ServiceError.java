package org.extensiblecatalog.ncip.v2.service;

public enum ServiceError {
    SERVICE_UNAVAILABLE,
    INVALID_MESSAGE_FORMAT,
    UNSUPPORTED_REQUEST,
    RUNTIME_ERROR,
    INVALID_SCHEME_VALUE,
    CONFIGURATION_ERROR;

    private ServiceError() {
    }
}
