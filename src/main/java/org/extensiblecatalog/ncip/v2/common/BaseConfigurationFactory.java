package org.extensiblecatalog.ncip.v2.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseConfigurationFactory<CONFIG extends ToolkitConfiguration> implements ToolkitComponentConfigurationFactory {
    private static final Logger logger = LoggerFactory.getLogger(BaseConfigurationFactory.class);

    public BaseConfigurationFactory() {
    }

    protected static ToolkitConfiguration buildConfiguration(String appName, String componentName, String componentSpringConfigFilenameKey, String componentSpringConfigFilenameDefault, Properties properties, String configClassNameKey, String configClassNameDefault, String propertiesFilenameKey, String propertiesFilenameDefault, String localPropertiesFilenameKey, String localPropertiesFilenameDefault, String configPropertyOverrideKey, String configPropertyOverrideDefault) throws ToolkitException {
        Properties mergedProperties = ConfigurationHelper.populateProperties(appName, properties, propertiesFilenameKey, propertiesFilenameDefault, localPropertiesFilenameKey, localPropertiesFilenameDefault, configPropertyOverrideKey, configPropertyOverrideDefault);
        String componentSpringConfigFilename = mergedProperties.getProperty(componentSpringConfigFilenameKey, componentSpringConfigFilenameDefault);
        String coreSpringConfigFilename = mergedProperties.getProperty("CoreConfiguration.SpringConfigFile", CoreConfiguration.CORE_CONFIG_FILE_NAME_DEFAULT);
        ToolkitConfiguration toolkitConfig = ConfigurationHelper.getComponentConfiguration(appName, componentName, componentSpringConfigFilename, coreSpringConfigFilename);
        if (toolkitConfig == null) {
            ToolkitComponentConfigurationFactory configFactory = ConfigurationHelper.getComponentConfigurationFactory(appName, componentName, componentSpringConfigFilename, coreSpringConfigFilename);
            if (configFactory != null) {
                toolkitConfig = configFactory.getConfiguration();
            }
        }

        if (toolkitConfig == null && componentName.compareTo(Core.COMPONENT_NAME) != 0) {
            CoreConfiguration coreConfig = ConfigurationHelper.getCoreConfiguration(appName, properties, coreSpringConfigFilename);
            if (coreConfig != null && coreConfig.isConfigurationSet(componentName)) {
                toolkitConfig = coreConfig.getConfiguration(componentName);
            }
        }

        if (toolkitConfig == null) {
            String configClassName = mergedProperties.getProperty(configClassNameKey, configClassNameDefault);
            if (configClassName == null) {
                throw new ToolkitException(configClassNameKey + " property was set to null");
            }

            try {
                Class<?> configClass = Class.forName(configClassName);
                Constructor ctor = configClass.getConstructor(Properties.class);
                toolkitConfig = (ToolkitConfiguration)ctor.newInstance(mergedProperties);
            } catch (ClassNotFoundException var20) {
                throw new ToolkitException("Exception loading configuration class.", var20);
            } catch (InstantiationException var21) {
                throw new ToolkitException("Exception constructing configuration class.", var21);
            } catch (IllegalAccessException var22) {
                throw new ToolkitException("Exception constructing configuration class.", var22);
            } catch (NoSuchMethodException var23) {
                throw new ToolkitException("Exception constructing configuration class.", var23);
            } catch (InvocationTargetException var24) {
                throw new ToolkitException("Exception constructing configuration class.", var24);
            }
        }

        return toolkitConfig;
    }
}
