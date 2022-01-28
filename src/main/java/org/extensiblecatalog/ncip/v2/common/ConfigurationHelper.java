//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import javax.servlet.ServletContext;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigurationHelper {
    private static final Logger logger = LoggerFactory.getLogger(ConfigurationHelper.class);
    protected static final String FACTORY_BEAN_SUFFIX = "Factory";
    protected static final String CONFIGURATION_BEAN_SUFFIX = "Configuration";
    protected static final String CONFIGURATION_FACTORY_BEAN_SUFFIX = "ConfigurationFactory";
    protected static final String CORE_COMPONENT_NAME = "Core";
    protected static Object globalAppContext;
    protected static Map<String, Object> applicationContextMap = new HashMap();
    protected static Map<String, Properties> applicationPropertiesMap = new HashMap();

    public ConfigurationHelper() {
    }

    public static void setApplicationContext(Object globalApplicationContext) {
        globalAppContext = globalApplicationContext;
    }

    private static synchronized Object getApplicationContext(String appName, String componentName, String componentConfigFilename, String coreConfigFilename) {
        Object appContext = doApplicationContextLoad(appName, componentName, componentConfigFilename);
        if (appContext == null) {
            appContext = doApplicationContextLoad(appName, "Core", coreConfigFilename);
            if (appContext == null && appName != null) {
                appContext = doApplicationContextLoad((String)null, componentName, componentConfigFilename);
                if (appContext == null) {
                    appContext = doApplicationContextLoad((String)null, "Core", coreConfigFilename);
                }
            }
        }

        return appContext;
    }

    private static synchronized Object doApplicationContextLoad(String appName, String componentName, String configFilename) {
        String key = appName + ":" + componentName;
        Object appContext;
        if (!applicationContextMap.containsKey(key)) {
            logger.debug("AppContext for '" + key + "' not loaded; loading now...");
            appContext = getApplicationContext(configFilename);
            applicationContextMap.put(key, appContext);
            logger.debug("AppContext '" + appContext + "' for '" + key + "' now loaded.");
        } else {
            logger.debug("AppContext for '" + key + "' already loaded.");
        }

        appContext = applicationContextMap.get(key);
        return appContext;
    }

    private static synchronized Object getApplicationContext(String componentConfigFilename) {
        Object appContext = null;
        if (componentConfigFilename != null && !componentConfigFilename.isEmpty()) {
            try {
                appContext = new ClassPathXmlApplicationContext(componentConfigFilename);
                logger.debug("Loaded application context from '" + componentConfigFilename + "'.");
            } catch (RuntimeException var3) {
                logger.debug("No application context at '" + componentConfigFilename + "'. Runtime exception: ", var3);
            }
        } else {
            logger.debug("No default Spring configuration filename.");
        }

        return appContext;
    }

    private static synchronized Object getGlobalApplicationContext() {
        if (globalAppContext == null) {
            globalAppContext = getApplicationContext(System.getProperty("CoreConfiguration.SpringConfigFile", CoreConfiguration.CORE_CONFIG_FILE_NAME_DEFAULT));
        }

        return globalAppContext;
    }

    public static CoreConfiguration getCoreConfiguration() throws ToolkitException {
        return getCoreConfiguration((String)null, System.getProperties(), System.getProperty("CoreConfiguration.SpringConfigFile", CoreConfiguration.CORE_CONFIG_FILE_NAME_DEFAULT));
    }

    public static CoreConfiguration getCoreConfiguration(String appName, Properties properties, String coreConfigFilename) throws ToolkitException {
        CoreConfiguration coreConfiguration = (CoreConfiguration)getComponentConfiguration(appName, "Core", (String)null, coreConfigFilename);
        if (coreConfiguration == null) {
            CoreConfigurationFactory coreConfigFactory = (CoreConfigurationFactory)getComponentConfigurationFactory(appName, "Core", (String)null, coreConfigFilename);
            if (coreConfigFactory != null) {
                coreConfiguration = CoreConfigurationFactory.buildConfiguration(appName);
            }
        }

        if (coreConfiguration == null) {
            coreConfiguration = CoreConfigurationFactory.buildConfiguration(appName, properties);
        }

        return coreConfiguration;
    }

    protected static String makeBeanName(String componentName) {
        return componentName.substring(0, 1).toLowerCase() + componentName.substring(1);
    }

    public static ToolkitComponent getComponent(String appName, String componentName, String componentConfigFilename, String coreConfigFilename) {
        ToolkitComponent component = null;
        String beanName = makeBeanName(componentName);
        logger.debug("Looking for bean with name '" + beanName + "' in Spring Application context for appName '" + appName + "' and componentName '" + componentName + "', using componentConfigFilename of '" + componentConfigFilename + "' and coreConfigFilename of '" + coreConfigFilename + "'.");
        ApplicationContext theAppContext = (ApplicationContext)getApplicationContext(appName, componentName, componentConfigFilename, coreConfigFilename);
        if (theAppContext != null) {
            if (theAppContext.containsBean(beanName)) {
                component = (ToolkitComponent)theAppContext.getBean(beanName);
                logger.debug("Found " + component);
            } else {
                logger.debug("Bean '" + beanName + "' not found.");
            }
        } else {
            logger.debug("Application Context for appName '" + appName + "' and componentName '" + componentName + "', using componentConfigFilename of '" + componentConfigFilename + "' and coreConfigFilename of '" + coreConfigFilename + "' not found.");
        }

        if (component == null) {
            logger.debug("Looking for bean with name '" + beanName + "' in global Spring Application context.");
            ApplicationContext globalAppContext = (ApplicationContext)getGlobalApplicationContext();
            if (globalAppContext != null) {
                if (globalAppContext.containsBean(beanName)) {
                    component = (ToolkitComponent)globalAppContext.getBean(beanName);
                    logger.debug("Found " + component);
                } else {
                    logger.debug("Bean '" + beanName + "' not found.");
                }
            } else {
                logger.debug("No global Application Context.");
            }
        }

        return component;
    }

    public static ToolkitComponentFactory getComponentFactory(String appName, String componentName, String componentConfigFilename, String coreConfigFilename) {
        ToolkitComponentFactory component = null;
        String beanName = makeBeanName(componentName) + "Factory";
        ApplicationContext theAppContext = (ApplicationContext)getApplicationContext(appName, componentName, componentConfigFilename, coreConfigFilename);
        if (theAppContext != null && theAppContext.containsBean(beanName)) {
            component = (ToolkitComponentFactory)theAppContext.getBean(beanName);
        }

        return component;
    }

    public static ToolkitConfiguration getComponentConfiguration(String appName, String componentName, String componentConfigFilename, String coreConfigFilename) {
        ToolkitConfiguration componentConfiguration = null;
        String beanName = makeBeanName(componentName) + "Configuration";
        ApplicationContext theAppContext = (ApplicationContext)getApplicationContext(appName, componentName, componentConfigFilename, coreConfigFilename);
        if (theAppContext != null && theAppContext.containsBean(beanName)) {
            componentConfiguration = (ToolkitConfiguration)theAppContext.getBean(beanName);
        }

        return componentConfiguration;
    }

    public static ToolkitComponentConfigurationFactory getComponentConfigurationFactory(String appName, String componentName, String componentConfigFilename, String coreConfigFilename) {
        ToolkitComponentConfigurationFactory componentConfigurationFactory = null;
        String beanName = makeBeanName(componentName) + "ConfigurationFactory";
        ApplicationContext theAppContext = (ApplicationContext)getApplicationContext(appName, componentName, componentConfigFilename, coreConfigFilename);
        if (theAppContext != null && theAppContext.containsBean(beanName)) {
            componentConfigurationFactory = (ToolkitComponentConfigurationFactory)theAppContext.getBean(beanName);
        }

        return componentConfigurationFactory;
    }

    public static void setServerContextProperties(String appName, Properties props) {
        applicationPropertiesMap.put(appName, props);
    }

    public static Properties getServerContextProperties(String appName) {
        return (Properties)applicationPropertiesMap.get(appName);
    }

    protected static Properties populateProperties(String appName, Properties overrideProperties, String propertiesFilenameKey, String propertiesFilenameDefault, String localPropertiesFilenameKey, String localPropertiesFilenameDefault, String configPropertyOverrideKey, String configPropertyOverrideDefault) {
        Properties properties = System.getProperties();
        ToolkitHelper.setPropertiesFromClasspathOrFilesystem(properties, System.getProperty("ToolkitConfiguration.PropertiesFile", "toolkit.properties"));
        ToolkitHelper.setPropertiesFromClasspathOrFilesystem(properties, System.getProperty("ToolkitConfiguration.LocalPropertiesFile", "${ToolkitConfiguration.AppName}toolkit.properties"));
        String propertiesFileName = System.getProperty("ToolkitConfiguration.PropertiesFileOverride", ToolkitConfiguration.TOOLKIT_CONFIG_PROPERTY_OVERRIDE_DEFAULT);
        if (propertiesFileName != null) {
            ToolkitHelper.setPropertiesFromClasspathOrFilesystem(properties, propertiesFileName);
        }

        ToolkitHelper.setPropertiesFromClasspathOrFilesystem(properties, System.getProperty(propertiesFilenameKey, propertiesFilenameDefault));
        ToolkitHelper.setPropertiesFromClasspathOrFilesystem(properties, System.getProperty(localPropertiesFilenameKey, localPropertiesFilenameDefault));
        propertiesFileName = System.getProperty(configPropertyOverrideKey, configPropertyOverrideDefault);
        if (propertiesFileName != null) {
            ToolkitHelper.setPropertiesFromClasspathOrFilesystem(properties, propertiesFileName);
        }

        if (appName == null) {
            logger.debug("appName parameter is null; getting appName from properties.");
            appName = properties.getProperty("ToolkitConfiguration.AppName", "local");
        }

        Properties serverContextProperties = getServerContextProperties(appName);
        if (serverContextProperties != null) {
            properties.putAll(serverContextProperties);
        }

        if (overrideProperties != null) {
            properties.putAll(overrideProperties);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Properties files loaded:");
            Iterator var11 = properties.entrySet().iterator();

            while(var11.hasNext()) {
                Entry<Object, Object> entry = (Entry)var11.next();
                if (((String)entry.getKey()).contains("FileTitle")) {
                    logger.debug(entry.getKey() + "=" + entry.getValue());
                }
            }
        }

        return properties;
    }

    public static String getAppName(ServletContext servletContext) {
        String appName;
        if (servletContext.getContextPath().startsWith("/")) {
            appName = servletContext.getContextPath().substring(1);
        } else {
            appName = servletContext.getContextPath();
        }

        return appName;
    }
}
