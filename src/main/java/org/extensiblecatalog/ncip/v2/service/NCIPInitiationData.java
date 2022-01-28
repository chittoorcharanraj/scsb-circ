package org.extensiblecatalog.ncip.v2.service;

public interface NCIPInitiationData extends NCIPData {
    InitiationHeader getInitiationHeader();

    AgencyId getRelyingPartyId();

    void setRelyingPartyId(AgencyId var1);
}
