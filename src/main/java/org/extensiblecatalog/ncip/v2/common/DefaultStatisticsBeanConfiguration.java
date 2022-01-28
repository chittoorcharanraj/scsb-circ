package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultStatisticsBeanConfiguration extends BaseToolkitConfiguration implements StatisticsBeanConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(DefaultStatisticsBeanConfiguration.class);
    protected String statisticsBeanClassName;

    public DefaultStatisticsBeanConfiguration() {
        this.statisticsBeanClassName = StatisticsBeanConfiguration.STATISTICS_BEAN_CLASS_NAME_DEFAULT;
    }

    public DefaultStatisticsBeanConfiguration(String appName) {
        this(appName, (Properties)null);
    }

    public DefaultStatisticsBeanConfiguration(Properties properties) {
        this((String)null, properties);
    }

    public DefaultStatisticsBeanConfiguration(String appName, Properties properties) {
        super(appName, properties);
        this.statisticsBeanClassName = StatisticsBeanConfiguration.STATISTICS_BEAN_CLASS_NAME_DEFAULT;
        String statisticsBeanClassNameString = null;
        if (properties != null) {
            statisticsBeanClassNameString = this.properties.getProperty("StatisticsBeanConfiguration.ClassName");
        }

        if (statisticsBeanClassNameString != null) {
            this.statisticsBeanClassName = statisticsBeanClassNameString;
        }

    }

    public String getComponentClassName() {
        return this.statisticsBeanClassName;
    }

    public void setComponentClassName(String componentClassName) {
        this.statisticsBeanClassName = componentClassName;
    }
}
