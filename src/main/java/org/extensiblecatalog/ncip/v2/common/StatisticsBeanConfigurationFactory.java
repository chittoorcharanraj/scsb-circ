package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatisticsBeanConfigurationFactory extends BaseConfigurationFactory<StatisticsBeanConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(StatisticsBeanConfigurationFactory.class);
    protected StatisticsBeanConfiguration configuration;

    public StatisticsBeanConfigurationFactory() throws ToolkitException {
    }

    public StatisticsBeanConfigurationFactory(String appName) throws ToolkitException {
        this.configuration = buildConfiguration(appName);
    }

    public StatisticsBeanConfigurationFactory(String appName, Properties properties) throws ToolkitException {
        this.configuration = buildConfiguration(appName, properties);
    }

    public StatisticsBeanConfigurationFactory(Properties properties) throws ToolkitException {
        this.configuration = buildConfiguration(properties);
    }

    public StatisticsBeanConfigurationFactory(StatisticsBeanConfiguration configInstance) throws ToolkitException {
        this.configuration = configInstance;
    }

    public StatisticsBeanConfiguration getConfiguration() {
        return this.configuration;
    }

    public static StatisticsBeanConfiguration buildConfiguration() throws ToolkitException {
        return buildConfiguration((String)null, (Properties)null);
    }

    public static StatisticsBeanConfiguration buildConfiguration(Properties properties) throws ToolkitException {
        return buildConfiguration((String)null, properties);
    }

    public static StatisticsBeanConfiguration buildConfiguration(String appName) throws ToolkitException {
        return buildConfiguration(appName, (Properties)null);
    }

    public static StatisticsBeanConfiguration buildConfiguration(String appName, Properties properties) throws ToolkitException {
        StatisticsBeanConfiguration config = (StatisticsBeanConfiguration)buildConfiguration(appName, StatisticsBean.COMPONENT_NAME, "StatisticsBeanConfiguration.SpringConfigFile", StatisticsBeanConfiguration.STATISTICS_BEAN_CONFIG_FILE_NAME_DEFAULT, properties, "StatisticsBeanConfiguration.ConfigClass", StatisticsBeanConfiguration.STATISTICS_BEAN_CONFIG_CLASS_NAME_DEFAULT, "StatisticsBeanConfiguration.PropertiesFile", "statisticsbean.properties", "StatisticsBeanConfiguration.LocalPropertiesFile", "${ToolkitConfiguration.AppName}statisticsbean.properties", "StatisticsBeanConfiguration.PropertiesFileOverride", StatisticsBeanConfiguration.STATISTICS_BEAN_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT);
        return config;
    }
}
