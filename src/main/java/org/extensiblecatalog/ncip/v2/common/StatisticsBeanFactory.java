package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;
import org.extensiblecatalog.ncip.v2.binding.jaxb.JAXBHelper;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatisticsBeanFactory extends BaseComponentFactory<StatisticsBean, StatisticsBeanConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(StatisticsBeanFactory.class);
    protected StatisticsBean statisticsBean;

    public StatisticsBeanFactory() throws ToolkitException {
    }

    public StatisticsBeanFactory(Properties properties) throws ToolkitException {
        this.statisticsBean = buildStatisticsBean(properties);
    }

    public StatisticsBeanFactory(String appName) throws ToolkitException {
        this.statisticsBean = buildStatisticsBean(appName);
    }

    public StatisticsBeanFactory(String appName, Properties properties) throws ToolkitException {
        this.statisticsBean = buildStatisticsBean(appName, properties);
    }

    public StatisticsBeanFactory(StatisticsBeanConfiguration configuration) throws ToolkitException {
        this.statisticsBean = (StatisticsBean)buildComponent(configuration);
    }

    public StatisticsBean getComponent() {
        return this.statisticsBean;
    }

    public static StatisticsBean buildStatisticsBean() throws ToolkitException {
        return buildStatisticsBean((String)null, (Properties)null);
    }

    public static StatisticsBean buildStatisticsBean(Properties properties) throws ToolkitException {
        return buildStatisticsBean((String)null, properties);
    }

    public static StatisticsBean buildStatisticsBean(String appName) throws ToolkitException {
        return buildStatisticsBean(appName, (Properties)null);
    }

    public static StatisticsBean buildStatisticsBean(StatisticsBeanConfiguration configuration) throws ToolkitException {
        return (StatisticsBean)buildComponent(configuration);
    }

    public static StatisticsBean buildStatisticsBean(String appName, Properties properties) throws ToolkitException {
        StatisticsBean sb = (StatisticsBean)buildComponent(StatisticsBeanFactory.class, appName, StatisticsBean.COMPONENT_NAME, "StatisticsBeanConfiguration.SpringConfigFile", StatisticsBeanConfiguration.STATISTICS_BEAN_CONFIG_FILE_NAME_DEFAULT, properties, "StatisticsBeanConfiguration.PropertiesFile", "statisticsbean.properties", "StatisticsBeanConfiguration.LocalPropertiesFile", "${ToolkitConfiguration.AppName}statisticsbean.properties", "StatisticsBeanConfiguration.PropertiesFileOverride", StatisticsBeanConfiguration.STATISTICS_BEAN_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT);
        return sb;
    }
}
