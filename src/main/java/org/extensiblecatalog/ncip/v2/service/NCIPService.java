package org.extensiblecatalog.ncip.v2.service;

public interface NCIPService<NCIPInitiationData, NCIPResponseData> {
    NCIPResponseData performService(NCIPInitiationData var1, ServiceContext var2, RemoteServiceManager var3) throws ServiceException, ValidationException;
}
