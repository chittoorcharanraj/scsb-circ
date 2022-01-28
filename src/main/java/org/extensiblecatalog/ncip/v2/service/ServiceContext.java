package org.extensiblecatalog.ncip.v2.service;

public interface ServiceContext {
    void validateBeforeMarshalling(NCIPMessage var1) throws ValidationException;

    void validateAfterUnmarshalling(NCIPMessage var1) throws ValidationException;
}
