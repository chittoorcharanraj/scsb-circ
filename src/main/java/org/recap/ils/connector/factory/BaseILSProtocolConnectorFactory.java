package org.recap.ils.connector.factory;

import org.recap.ils.connector.AbstractProtocolConnector;

public abstract class BaseILSProtocolConnectorFactory {
    public abstract AbstractProtocolConnector getIlsProtocolConnector(String instituteCode);
}
