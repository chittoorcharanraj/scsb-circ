package org.extensiblecatalog.ncip.v2.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseComponentFactory<COMPONENT extends ToolkitComponent, CONFIG extends ToolkitConfiguration> implements ToolkitComponentFactory {
    private static final Logger logger = LoggerFactory.getLogger(BaseComponentFactory.class);

    public BaseComponentFactory() {
    }

    public static <F extends ToolkitComponentFactory> ToolkitComponent buildComponent(Class<F> factoryClass, String appName, String componentName, String componentSpringConfigFilenameKey, String componentSpringConfigFilenameDefault, Properties properties, String propertiesFilenameKey, String propertiesFilenameDefault, String localPropertiesFilenameKey, String localPropertiesFilenameDefault, String configPropertyOverrideKey, String configPropertyOverrideDefault) throws ToolkitException {
        Properties mergedProperties = ConfigurationHelper.populateProperties(appName, properties, propertiesFilenameKey, propertiesFilenameDefault, localPropertiesFilenameKey, localPropertiesFilenameDefault, configPropertyOverrideKey, configPropertyOverrideDefault);
        String componentSpringConfigFilename = mergedProperties.getProperty(componentSpringConfigFilenameKey, componentSpringConfigFilenameDefault);
        String coreSpringConfigFilename = mergedProperties.getProperty("CoreConfiguration.SpringConfigFile", CoreConfiguration.CORE_CONFIG_FILE_NAME_DEFAULT);
        ToolkitComponent component = ConfigurationHelper.getComponent(appName, componentName, componentSpringConfigFilename, coreSpringConfigFilename);
        if (component == null) {
            ToolkitComponentFactory componentFactory = ConfigurationHelper.getComponentFactory(appName, componentName, componentSpringConfigFilename, coreSpringConfigFilename);
            if (componentFactory != null) {
                if (componentFactory.getClass().isInstance(factoryClass)) {
                    throw new ToolkitException("Recursive call to component factory '" + componentFactory.getClass().getName() + "'.");
                }

                component = componentFactory.getComponent();
            }
        }

        if (component == null) {
            ToolkitConfiguration toolkitConfig = ConfigurationHelper.getComponentConfiguration(appName, componentName, componentSpringConfigFilename, coreSpringConfigFilename);
            if (toolkitConfig != null) {
                component = buildComponent(toolkitConfig);
            }
        }

        if (component == null) {
            ToolkitComponentConfigurationFactory configFactory = ConfigurationHelper.getComponentConfigurationFactory(appName, componentName, componentSpringConfigFilename, coreSpringConfigFilename);
            if (configFactory != null) {
                component = buildComponent(configFactory.getConfiguration());
            }
        }

        if (component == null) {
            CoreConfiguration coreConfig = ConfigurationHelper.getCoreConfiguration(appName, mergedProperties, coreSpringConfigFilename);
            if (coreConfig != null) {
                component = buildComponent(coreConfig.getConfiguration(componentName));
            }
        }

        if (component == null) {
            throw new ToolkitException("Unable to initialize " + componentName + ".");
        } else {
            return component;
        }
    }

    protected static ToolkitComponent buildComponent(ToolkitConfiguration configuration) throws ToolkitException {
        String componentClassName = configuration.getComponentClassName();
        if (componentClassName != null) {
            try {
                Class<? extends ToolkitComponent> componentClass = Class.forName(componentClassName).asSubclass(ToolkitComponent.class);
                Constructor<? extends ToolkitComponent> ctor = ConstructorUtils.getMatchingAccessibleConstructor(componentClass, new Class[]{configuration.getClass()});
                if (ctor != null) {
                    ToolkitComponent component = (ToolkitComponent)ctor.newInstance(configuration);
                    return component;
                } else {
                    throw new ToolkitException("Exception constructing " + componentClassName + " class: No matching constructor found for '" + configuration.getClass().getName() + "'.");
                }
            } catch (ClassNotFoundException var5) {
                throw new ToolkitException("Exception loading " + componentClassName + " class.", var5);
            } catch (InstantiationException var6) {
                throw new ToolkitException("Exception constructing " + componentClassName + " class.", var6);
            } catch (IllegalAccessException var7) {
                throw new ToolkitException("Exception constructing " + componentClassName + " class.", var7);
            } catch (InvocationTargetException var8) {
                throw new ToolkitException("Exception constructing " + componentClassName + " class.", var8);
            }
        } else {
            throw new ToolkitException("Component class name not set in component configuration.");
        }
    }
}
