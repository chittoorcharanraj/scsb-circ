//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.binding.jaxb.dozer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import org.apache.logging.log4j.Level;
import org.dozer.DozerBeanMapper;
import org.extensiblecatalog.ncip.v2.binding.jaxb.JAXBHelper;
import org.extensiblecatalog.ncip.v2.binding.jaxb.MarshallerFactory;
import org.extensiblecatalog.ncip.v2.binding.jaxb.NamespaceFilter;
import org.extensiblecatalog.ncip.v2.common.LoggingHelper;
import org.extensiblecatalog.ncip.v2.common.NCIPServiceContext;
import org.extensiblecatalog.ncip.v2.common.StatisticsBean;
import org.extensiblecatalog.ncip.v2.common.StatisticsBeanFactory;
import org.extensiblecatalog.ncip.v2.common.Translator;
import org.extensiblecatalog.ncip.v2.common.TranslatorConfiguration;
import org.extensiblecatalog.ncip.v2.common.TranslatorConfigurationFactory;
import org.extensiblecatalog.ncip.v2.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public abstract class BaseJAXBDozerTranslator<M> implements Translator {
    private static final Logger logger = LoggerFactory.getLogger(BaseJAXBDozerTranslator.class);
    protected DozerBeanMapper mapper;
    protected MarshallerFactory marshallerFactory;
    protected StatisticsBean statisticsBean;
    protected boolean logMessages;
    protected Level messagesLoggingLevel;

    public BaseJAXBDozerTranslator() throws ToolkitException {
        this.logMessages = false;
        this.messagesLoggingLevel = Level.DEBUG;
    }

    public BaseJAXBDozerTranslator(Properties properties) throws ToolkitException {
        this(TranslatorConfigurationFactory.buildConfiguration(properties));
    }

    public BaseJAXBDozerTranslator(TranslatorConfiguration config) throws ToolkitException {
        this.logMessages = false;
        this.messagesLoggingLevel = Level.DEBUG;
        JAXBDozerNCIP2TranslatorConfiguration jaxbDozerNCIP2Config = (JAXBDozerNCIP2TranslatorConfiguration)config;
        this.statisticsBean = StatisticsBeanFactory.buildStatisticsBean();
        this.logMessages = config.getLogMessages();
        this.messagesLoggingLevel = config.getMessagesLoggingLevel();
        this.marshallerFactory = new MarshallerFactory(config);
        this.mapper = new DozerBeanMapper();
        this.mapper.setMappingFiles(jaxbDozerNCIP2Config.getMappingFiles());
    }

    public DozerBeanMapper getMapper() {
        return this.mapper;
    }

    public void setMapper(DozerBeanMapper mapper) {
        this.mapper = mapper;
    }

    public MarshallerFactory getMarshallerFactory() {
        return this.marshallerFactory;
    }

    public void setMarshallerFactory(MarshallerFactory marshallerFactory) {
        this.marshallerFactory = marshallerFactory;
    }

    public StatisticsBean getStatisticsBean() {
        return this.statisticsBean;
    }

    public void setStatisticsBean(StatisticsBean statisticsBean) {
        this.statisticsBean = statisticsBean;
    }

    public boolean getLogMessages() {
        return this.logMessages;
    }

    public void setLogMessages(boolean logMessages) {
        this.logMessages = logMessages;
    }

    public Level getMessagesLoggingLevel() {
        return this.messagesLoggingLevel;
    }

    public void setMessagesLoggingLevel(Level messagesLoggingLevel) {
        this.messagesLoggingLevel = messagesLoggingLevel;
    }

    public NCIPInitiationData createInitiationData(ServiceContext serviceContext, InputStream inputStream) throws ServiceException, ValidationException {
        try {
            if (this.logMessages) {
                inputStream = LoggingHelper.copyAndLogStream(logger, this.messagesLoggingLevel, inputStream);
            }

            long initUnmarshalStartTime = System.currentTimeMillis();
            M initiationMsg = this.createNCIPMessage(serviceContext, inputStream);
            String msgName = JAXBHelper.getMessageName(initiationMsg);
            long initUnmarshalEndTime = System.currentTimeMillis();
            this.statisticsBean.record(initUnmarshalStartTime, initUnmarshalEndTime, new Object[]{StatisticsBean.RESPONDER_UNMARSHAL_MESSAGE_LABELS, msgName});
            long initTranslateStartTime = System.currentTimeMillis();
            NCIPMessage svcMessage = (NCIPMessage)this.mapper.map(initiationMsg, NCIPMessage.class);
            long initTranslateEndTime = System.currentTimeMillis();
            serviceContext.validateAfterUnmarshalling(svcMessage);
            NCIPInitiationData initiationData = svcMessage.getInitiationData();
            this.statisticsBean.record(initTranslateStartTime, initTranslateEndTime, new Object[]{StatisticsBean.RESPONDER_CREATE_DATA_LABELS, msgName});
            return initiationData;
        } catch (IllegalAccessException var15) {
            throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "Exception unwrapping the initiation message.", var15);
        } catch (InvocationTargetException var16) {
            throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "Exception unwrapping the initiation message.", var16);
        } catch (ToolkitException var17) {
            throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "ToolkitException creating the NCIPInitiationData object from the input stream.", var17);
        }
    }

    public NCIPResponseData createResponseData(ServiceContext serviceContext, InputStream responseMsgInputStream) throws ServiceException, ValidationException {
        try {
            if (this.logMessages) {
                responseMsgInputStream = LoggingHelper.copyAndLogStream(logger, this.messagesLoggingLevel, responseMsgInputStream);
            }

            long respUnmarshalStartTime = System.currentTimeMillis();
            M responseMsg = this.createNCIPMessage(serviceContext, responseMsgInputStream);
            String msgName = JAXBHelper.getMessageName(responseMsg);
            long respUnmarshalEndTime = System.currentTimeMillis();
            this.statisticsBean.record(respUnmarshalStartTime, respUnmarshalEndTime, new Object[]{StatisticsBean.RESPONDER_UNMARSHAL_MESSAGE_LABELS, msgName});
            long respTranslateStartTime = System.currentTimeMillis();
            NCIPMessage svcMessage = (NCIPMessage)this.mapper.map(responseMsg, NCIPMessage.class);
            long respTranslateEndTime = System.currentTimeMillis();
            serviceContext.validateAfterUnmarshalling(svcMessage);
            NCIPResponseData responseData = svcMessage.getResponseData();
            this.statisticsBean.record(respTranslateStartTime, respTranslateEndTime, new Object[]{StatisticsBean.RESPONDER_CREATE_DATA_LABELS, msgName});
            return responseData;
        } catch (IllegalAccessException var15) {
            throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "Exception unwrapping the response message.", var15);
        } catch (InvocationTargetException var16) {
            throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "Exception unwrapping the response message.", var16);
        } catch (ToolkitException var17) {
            throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "ToolkitException creating the NCIPResponseData object from the input stream.", var17);
        }
    }

    public ByteArrayInputStream createInitiationMessageStream(ServiceContext serviceContext, NCIPInitiationData initiationData) throws ServiceException, ValidationException {
        try {
            String msgName = ServiceHelper.getMessageName(initiationData);
            NCIPMessage svcNCIPMessage = new NCIPMessage();
            ReflectionHelper.setField(svcNCIPMessage, initiationData, msgName);
            serviceContext.validateBeforeMarshalling(svcNCIPMessage);
            long initTranslateStartTime = System.currentTimeMillis();
            M ncipMsg = this.mapMessage(svcNCIPMessage, this.mapper);
            long initTranslateEndTime = System.currentTimeMillis();
            this.statisticsBean.record(initTranslateStartTime, initTranslateEndTime, new Object[]{StatisticsBean.RESPONDER_CREATE_MESSAGE_LABELS, msgName});
            long initMarshalStartTime = System.currentTimeMillis();
            ByteArrayInputStream initMsgStream = this.createMsgStream(serviceContext, ncipMsg);
            long initMarshalEndTime = System.currentTimeMillis();
            this.statisticsBean.record(initMarshalStartTime, initMarshalEndTime, new Object[]{StatisticsBean.RESPONDER_MARSHAL_MESSAGE_LABELS, msgName});
            if (this.logMessages) {
                initMsgStream = (ByteArrayInputStream)LoggingHelper.copyAndLogStream(logger, this.messagesLoggingLevel, initMsgStream);
            }

            return initMsgStream;
        } catch (InvocationTargetException var15) {
            throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "InvocationTargetException creating the NCIPMessage from the NCIPInitiationData object.", var15);
        } catch (IllegalAccessException var16) {
            throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "IllegalAccessException creating the NCIPMessage from the NCIPInitiationData object.", var16);
        } catch (ToolkitException var17) {
            throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "ToolkitException creating the NCIPMessage from the NCIPInitiationData object.", var17);
        }
    }

    public ByteArrayInputStream createResponseMessageStream(ServiceContext serviceContext, NCIPResponseData responseData) throws ServiceException, ValidationException {
        try {
            String msgName = ServiceHelper.getMessageName(responseData);
            NCIPMessage svcNCIPMessage = new NCIPMessage();
            ReflectionHelper.setField(svcNCIPMessage, responseData, msgName);
            serviceContext.validateBeforeMarshalling(svcNCIPMessage);
            long respTranslateStartTime = System.currentTimeMillis();
            M ncipMsg = this.mapMessage(svcNCIPMessage, this.mapper);
            long respTranslateEndTime = System.currentTimeMillis();
            this.statisticsBean.record(respTranslateStartTime, respTranslateEndTime, new Object[]{StatisticsBean.RESPONDER_CREATE_MESSAGE_LABELS, msgName});
            long respMarshalStartTime = System.currentTimeMillis();
            ByteArrayInputStream respMsgStream = this.createMsgStream(serviceContext, ncipMsg);
            long respMarshalEndTime = System.currentTimeMillis();
            this.statisticsBean.record(respMarshalStartTime, respMarshalEndTime, new Object[]{StatisticsBean.RESPONDER_MARSHAL_MESSAGE_LABELS, msgName});
            if (this.logMessages) {
                respMsgStream = (ByteArrayInputStream)LoggingHelper.copyAndLogStream(logger, this.messagesLoggingLevel, respMsgStream);
            }

            return respMsgStream;
        } catch (InvocationTargetException var15) {
            throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "InvocationTargetException creating the NCIPMessage from the NCIPResponseData object.", var15);
        } catch (IllegalAccessException var16) {
            throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "IllegalAccessException creating the NCIPMessage from the NCIPResponseData object.", var16);
        } catch (ToolkitException var17) {
            throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "ToolkitException creating the NCIPMessage from the NCIPResponseData object.", var17);
        }
    }

    protected ByteArrayInputStream createMsgStream(ServiceContext serviceContext, M ncipMsg) throws ServiceException {
        NCIPServiceContext ncipServiceContext = (NCIPServiceContext)serviceContext;

        try {
            Marshaller marshaller = this.marshallerFactory.getMarshaller(serviceContext);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(0);

            try {
                if (ncipServiceContext.addDefaultNamespace()) {
                    marshaller.marshal(ncipMsg, byteArrayOutputStream);
                } else {
                    marshaller.marshal(ncipMsg, byteArrayOutputStream);
                }
            } catch (JAXBException var8) {
                throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "JAXBException marshalling the message.", var8);
            }

            byte[] bytes = byteArrayOutputStream.toByteArray();
            ByteArrayInputStream resultStream = new ByteArrayInputStream(bytes);
            return resultStream;
        } catch (ToolkitException var9) {
            throw new ServiceException(ServiceError.RUNTIME_ERROR, "Toolkit creating the Mashaller.", var9);
        }
    }

    protected M createNCIPMessage(ServiceContext serviceContext, InputStream inputStream) throws ServiceException {
        try {
            Unmarshaller unmarshaller = this.marshallerFactory.getUnmarshaller(serviceContext);
            NCIPServiceContext ncipServiceContext = (NCIPServiceContext)serviceContext;

            try {
                if (ncipServiceContext.addDefaultNamespace()) {
                    XMLReader reader = XMLReaderFactory.createXMLReader();
                    NamespaceFilter inFilter = new NamespaceFilter(((NCIPServiceContext)serviceContext).getDefaultNamespace(), true);
                    inFilter.setParent(reader);
                    SAXSource saxSource = new SAXSource(inFilter, new InputSource(inputStream));
                    return (M)unmarshaller.unmarshal(saxSource);
                } else {
                    Map<String, Boolean> parserFeatures = ncipServiceContext.getParserFeatures();
                    if (parserFeatures != null && !parserFeatures.isEmpty()) {
                        SAXParserFactory parserFactory = SAXParserFactory.newInstance();

                        try {
                            Iterator var7 = parserFeatures.entrySet().iterator();

                            while(var7.hasNext()) {
                                Entry<String, Boolean> entry = (Entry)var7.next();
                                logger.debug("Setting feature " + (String)entry.getKey() + " to " + entry.getValue());
                                parserFactory.setFeature((String)entry.getKey(), (Boolean)entry.getValue());
                            }

                            SAXParser saxParser = parserFactory.newSAXParser();
                            XMLReader xmlReader = saxParser.getXMLReader();
                            UnmarshallerHandler uh = unmarshaller.getUnmarshallerHandler();
                            xmlReader.setContentHandler(uh);
                            xmlReader.parse(new InputSource(inputStream));
                            return (M)uh.getResult();
                        } catch (IOException var10) {
                            throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "Exception creating NCIPMessage object from InputStream.", var10);
                        } catch (ParserConfigurationException var11) {
                            throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "Exception creating NCIPMessage object from InputStream.", var11);
                        }
                    } else {
                        return (M)unmarshaller.unmarshal(inputStream);
                    }
                }
            } catch (JAXBException var12) {
                throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "Exception creating NCIPMessage object from InputStream.", var12);
            } catch (SAXException var13) {
                throw new ServiceException(ServiceError.RUNTIME_ERROR, "Exception creating NCIPMessage object from InputStream.", var13);
            }
        } catch (ToolkitException var14) {
            throw new ServiceException(ServiceError.RUNTIME_ERROR, "Exception creating NCIPMessage object from InputStream.", var14);
        }
    }

    protected abstract M mapMessage(Object var1, DozerBeanMapper var2);
}
