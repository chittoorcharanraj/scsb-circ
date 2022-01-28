package org.extensiblecatalog.ncip.v2.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.extensiblecatalog.ncip.v2.service.ServiceContext;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;

public class DefaultNCIPServiceValidator implements ServiceValidator {
    protected NCIPServiceValidatorConfiguration config;
    protected Constructor serviceContextClassConstructor;

    public DefaultNCIPServiceValidator(ServiceValidatorConfiguration config) {
        this.config = (NCIPServiceValidatorConfiguration)config;
    }

    public ServiceContext getInitialServiceContext() throws ToolkitException {
        synchronized(this) {
            if (this.serviceContextClassConstructor == null) {
                try {
                    this.serviceContextClassConstructor = Class.forName(this.config.getServiceContextClassName()).getConstructor(ServiceValidatorConfiguration.class);
                } catch (ClassNotFoundException var8) {
                    throw new ToolkitException(var8);
                } catch (NoSuchMethodException var9) {
                    throw new ToolkitException(var9);
                }
            }
        }

        try {
            ServiceContext result = (ServiceContext)this.serviceContextClassConstructor.newInstance(this.config);
            return result;
        } catch (InstantiationException var5) {
            throw new ToolkitException(var5);
        } catch (IllegalAccessException var6) {
            throw new ToolkitException(var6);
        } catch (InvocationTargetException var7) {
            throw new ToolkitException(var7);
        }
    }
}
