package org.extensiblecatalog.ncip.v2.service;

import java.util.List;

public class LocationName {
    protected List<LocationNameInstance> locationNameInstances;

    public LocationName() {
    }

    public void setLocationNameInstances(List<LocationNameInstance> locationNameInstances) {
        this.locationNameInstances = locationNameInstances;
    }

    public List<LocationNameInstance> getLocationNameInstances() {
        return this.locationNameInstances;
    }

    public LocationNameInstance getLocationNameInstance(int index) {
        return (LocationNameInstance)this.locationNameInstances.get(index);
    }
}
