
package org.extensiblecatalog.ncip.v2.service;

import java.util.GregorianCalendar;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BlockOrTrap {
    protected AgencyId agencyId;
    protected BlockOrTrapType blockOrTrapType;
    protected GregorianCalendar validFromDate;
    protected GregorianCalendar validToDate;

    public BlockOrTrap() {
    }

    public AgencyId getAgencyId() {
        return this.agencyId;
    }

    public void setAgencyId(AgencyId agencyId) {
        this.agencyId = agencyId;
    }

    public BlockOrTrapType getBlockOrTrapType() {
        return this.blockOrTrapType;
    }

    public void setBlockOrTrapType(BlockOrTrapType blockOrTrapType) {
        this.blockOrTrapType = blockOrTrapType;
    }

    public GregorianCalendar getValidFromDate() {
        return this.validFromDate;
    }

    public void setValidFromDate(GregorianCalendar validFromDate) {
        this.validFromDate = validFromDate;
    }

    public GregorianCalendar getValidToDate() {
        return this.validToDate;
    }

    public void setValidToDate(GregorianCalendar validToDate) {
        this.validToDate = validToDate;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
