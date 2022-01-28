package org.extensiblecatalog.ncip.v2.common;

public interface StatisticsBeanConfiguration extends ToolkitConfiguration {
    String STATISTICS_BEAN_PROPERTIES_FILE_TITLE_KEY = "StatisticsBeanConfiguration.PropertiesFileTitle";
    String STATISTICS_BEAN_PROPERTIES_FILE_TITLE_DEFAULT = null;
    String STATISTICS_BEAN_LOCAL_PROPERTIES_FILE_TITLE_KEY = "StatisticsBeanConfiguration.LocalPropertiesFileTitle";
    String STATISTICS_BEAN_LOCAL_PROPERTIES_FILE_TITLE_DEFAULT = null;
    String STATISTICS_BEAN_CONFIG_CLASS_NAME_KEY = "StatisticsBeanConfiguration.ConfigClass";
    String STATISTICS_BEAN_CONFIG_CLASS_NAME_DEFAULT = DefaultStatisticsBeanConfiguration.class.getName();
    String STATISTICS_BEAN_PROPERTIES_FILENAME_KEY = "StatisticsBeanConfiguration.PropertiesFile";
    String STATISTICS_BEAN_PROPERTIES_FILENAME_DEFAULT = "statisticsbean.properties";
    String STATISTICS_BEAN_LOCAL_PROPERTIES_FILENAME_KEY = "StatisticsBeanConfiguration.LocalPropertiesFile";
    String STATISTICS_BEAN_LOCAL_PROPERTIES_FILENAME_DEFAULT = "${ToolkitConfiguration.AppName}statisticsbean.properties";
    String STATISTICS_BEAN_CONFIG_PROPERTIES_FILE_OVERRIDE_KEY = "StatisticsBeanConfiguration.PropertiesFileOverride";
    String STATISTICS_BEAN_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT = null;
    String STATISTICS_BEAN_CONFIG_FILE_NAME_KEY = "StatisticsBeanConfiguration.SpringConfigFile";
    String STATISTICS_BEAN_CONFIG_FILE_NAME_DEFAULT = null;
    String STATISTICS_BEAN_CLASS_NAME_KEY = "StatisticsBeanConfiguration.ClassName";
    String STATISTICS_BEAN_CLASS_NAME_DEFAULT = StatisticsBean.class.getName();
}
