package org.extensiblecatalog.ncip.v2.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import org.extensiblecatalog.ncip.v2.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MappedMessageHandler implements MessageHandler {
    private static final Logger logger = LoggerFactory.getLogger(MappedMessageHandler.class);
    protected static final int NUMBER_OF_PARAMETERS_TO_PERFORM_SERVICE_METHOD = 3;
    protected Map<String, NCIPService<NCIPInitiationData, NCIPResponseData>> supportedServices;
    protected RemoteServiceManager serviceManager;

    public MappedMessageHandler() throws ToolkitException {
    }

    public MappedMessageHandler(Properties properties) throws ToolkitException {
        this(MessageHandlerConfigurationFactory.buildConfiguration(properties));
    }

    public MappedMessageHandler(MessageHandlerConfiguration config) throws ToolkitException {
        this.supportedServices = new HashMap();
        Properties properties = config.getProperties();
        Enumeration enumeration = properties.keys();

        while(enumeration.hasMoreElements()) {
            String key = (String)enumeration.nextElement();
            logger.debug("Property key=" + key);
            if (key.compareToIgnoreCase("java.version") == 0) {
                logger.debug("Java version is " + properties.get(key));
            }

            if (key.matches("(?i)[A-Za-z]+Service\\.Class")) {
                String className = (String)properties.get(key);
                logger.debug("Class name=" + className);
                if (className != null && !className.isEmpty() && className.compareToIgnoreCase("null") != 0) {
                    try {
                        Class<?> clazz = Class.forName(className);
                        Class<? extends NCIPService> xc = clazz.asSubclass(NCIPService.class);
                        logger.debug("Class as subclass=" + xc.getName());

                        try {
                            NCIPService serviceInstance;
                            try {
                                Constructor<? extends NCIPService> propertiesCtor = xc.getConstructor(Properties.class);
                                serviceInstance = (NCIPService)propertiesCtor.newInstance(properties);
                            } catch (NoSuchMethodException var23) {
                                serviceInstance = (NCIPService)xc.newInstance();
                            } catch (InvocationTargetException var24) {
                                throw new ToolkitException("Exception constructing " + className + " using Properties:", var24);
                            }

                            Method[] methods = clazz.getMethods();
                            Class initDataClass = null;
                            Method[] var11 = methods;
                            int var12 = methods.length;

                            for(int var13 = 0; var13 < var12; ++var13) {
                                Method method = var11[var13];
                                logger.debug("Testing method " + method.getName());
                                if (method.getName().compareToIgnoreCase("performService") == 0) {
                                    logger.debug("Method is performService.");
                                    Class[] parameterTypes = method.getParameterTypes();
                                    if (parameterTypes.length == 3) {
                                        logger.debug("Method takes " + parameterTypes.length + " parameters.");
                                        Class parameterClass = parameterTypes[0];
                                        logger.debug("ParameterType[0] is " + parameterClass.getName());
                                        if (parameterClass.getName().compareTo(Class.class.getName()) != 0) {
                                            initDataClass = parameterClass;
                                            if (parameterClass.getName().compareTo(Object.class.getName()) == 0) {
                                                logger.warn("Class first parameter is 'Object'; trying to use property key to get actual initDataClass.");
                                                String serviceName = key.substring(0, key.length() - "Service.Class".length());
                                                initDataClass = ServiceHelper.constructInitiationDataClass(serviceName);
                                            } else {
                                                logger.debug("The initDataClass is not 'Object'.");
                                            }

                                            logger.debug("Selecting " + initDataClass.getName() + " as initDataClass.");
                                            break;
                                        }

                                        logger.debug("The performService method for class " + clazz.getName() + " takes a Class parameter, which is disallowed.");
                                    } else {
                                        logger.debug("The performService method for class " + clazz.getName() + " has no parameters.");
                                    }
                                } else {
                                    logger.debug("Method is not performService.");
                                }
                            }

                            logger.debug("Finished checking methods.");
                            if (initDataClass == null) {
                                throw new ToolkitException("Unable to determine NCIPInitiationData sub-class with name '" + className + "' for " + key);
                            }

                            logger.debug("Putting " + serviceInstance.getClass().getName() + " into supportedServices map with key of " + initDataClass.getName() + ".");
                            this.supportedServices.put(initDataClass.getName(), serviceInstance);
                        } catch (InstantiationException var25) {
                            throw new ToolkitException("Exception while populating supported services.", var25);
                        } catch (IllegalAccessException var26) {
                            throw new ToolkitException("Exception while populating supported services.", var26);
                        }
                    } catch (ClassNotFoundException var27) {
                        throw new ToolkitException("Class not found exception while populating supported services.", var27);
                    }
                }
            } else if (key.matches("(?i)RemoteServiceManager\\.Class")) {
                try {
                    Class<?> clazz = Class.forName(properties.getProperty(key));
                    Constructor ctor = clazz.getConstructor(Properties.class);
                    this.serviceManager = (RemoteServiceManager)ctor.newInstance(properties);
                } catch (ClassNotFoundException var18) {
                    throw new ToolkitException("Exception while populating supported services.", var18);
                } catch (NoSuchMethodException var19) {
                    throw new ToolkitException("Exception while populating supported services.", var19);
                } catch (InvocationTargetException var20) {
                    throw new ToolkitException("Exception while populating supported services.", var20);
                } catch (InstantiationException var21) {
                    throw new ToolkitException("Exception while populating supported services.", var21);
                } catch (IllegalAccessException var22) {
                    throw new ToolkitException("Exception while populating supported services.", var22);
                }
            }
        }

        logger.debug("Finished with properties.");
        if (logger.isDebugEnabled()) {
            logger.debug("Service map for " + this + ":");
            Iterator var28 = this.supportedServices.entrySet().iterator();

            while(var28.hasNext()) {
                Entry<String, NCIPService<NCIPInitiationData, NCIPResponseData>> entry = (Entry)var28.next();
                logger.debug((String)entry.getKey() + "=" + entry.getValue());
            }
        }

    }

    /** @deprecated */
    @Deprecated
    public MappedMessageHandler(Map<String, NCIPService<NCIPInitiationData, NCIPResponseData>> supportedServices, RemoteServiceManager serviceManager) {
        this.supportedServices = supportedServices;
        this.serviceManager = serviceManager;
    }

    public void setRemoteServiceManager(RemoteServiceManager serviceManager) {
        this.serviceManager = serviceManager;
    }

    public void setSupportedServices(Map<String, NCIPService<NCIPInitiationData, NCIPResponseData>> supportedServices) {
        this.supportedServices = supportedServices;
    }

    public NCIPResponseData performService(NCIPInitiationData initiationData, ServiceContext serviceContext) {
        Object responseData;
        if (initiationData != null) {
            NCIPService<NCIPInitiationData, NCIPResponseData> service = null;
            if (logger.isDebugEnabled()) {
                logger.debug("Looking in supported services map (" + this + ") for service to handle " + initiationData.getClass().getName());
                Iterator var5 = this.supportedServices.entrySet().iterator();

                while(var5.hasNext()) {
                    Entry<String, NCIPService<NCIPInitiationData, NCIPResponseData>> entry = (Entry)var5.next();
                    logger.debug((String)entry.getKey() + "=" + entry.getValue());
                }
            }

            if (this.supportedServices != null) {
                service = (NCIPService)this.supportedServices.get(initiationData.getClass().getName());
                logger.debug("service is " + service);
            } else {
                logger.debug("supportedServices is null.");
            }

            if (service == null) {
                logger.debug("service is null, trying wildcard match.");
                service = (NCIPService)this.supportedServices.get(NCIPInitiationData.class.getName());
                logger.debug("service is " + service);
            }

            ProblemResponseData problemResponseData;
            if (service != null) {
                logger.debug("service is " + service + ", calling performService method.");

                try {
                    responseData = (NCIPResponseData)service.performService(initiationData, serviceContext, this.serviceManager);
                    logger.debug("Result from performService call is " + responseData);
                } catch (ServiceException var8) {
                    List<Problem> problems = ServiceHelper.generateProblems(Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE, "NCIPMessage", (String)null, "Exception:", var8);
                    problemResponseData = new ProblemResponseData();
                    problemResponseData.setProblems(problems);
                    responseData = problemResponseData;
                } catch (ValidationException var9) {
                    problemResponseData = new ProblemResponseData();
                    problemResponseData.setProblems(var9.getProblems());
                    responseData = problemResponseData;
                }
            } else {
                logger.debug("service is null, returning Unsupported Service response.");
                List<Problem> problems = ServiceHelper.createUnsupportedServiceProblems(initiationData);
                problemResponseData = new ProblemResponseData();
                problemResponseData.setProblems(problems);
                responseData = problemResponseData;
            }
        } else {
            logger.debug("initiationData is null, returning Temporary Processing Failure response.");
            List<Problem> problems = ServiceHelper.generateProblems(Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE, (String)null, (String)null, "Translation of initiation message failed (initiationData is null)");
            ProblemResponseData problemResponseData = new ProblemResponseData();
            problemResponseData.setProblems(problems);
            responseData = problemResponseData;
        }

        return (NCIPResponseData)responseData;
    }
}
