package org.recap.camel.requestinitialdataload;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.recap.PropertyKeyConstants;
import org.recap.ScsbConstants;
import org.recap.camel.EmailPayLoad;
import org.recap.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by harikrishnanv on 18/7/17.
 */
@Slf4j
@Service
@Scope("prototype")
public class RequestDataLoadEmailService {


    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private PropertyUtil propertyUtil;

    @Value("${" + PropertyKeyConstants.EMAIL_REQUEST_INITIAL_LOAD_SUBJECT + "}")
    private String subjectForRequestInitialDataLoad;

    private String institutionCode;

    public RequestDataLoadEmailService(String institutionCode){this.institutionCode=institutionCode;}

    public void processInput(Exchange exchange) {
        log.info("ReqeustDataLoad EMailservice started for {}", institutionCode);
        String fileNameWithPath = (String)exchange.getIn().getHeader("CamelAwsS3Key");
        producerTemplate.sendBodyAndHeader(ScsbConstants.EMAIL_Q, getEmailPayLoad(fileNameWithPath), ScsbConstants.EMAIL_BODY_FOR, ScsbConstants.REQUEST_INITIAL_DATA_LOAD);
    }

    public EmailPayLoad getEmailPayLoad(String fileNameWithPath){
        EmailPayLoad emailPayLoad = new EmailPayLoad();
        emailPayLoad.setTo(emailIdTo(institutionCode));
        emailPayLoad.setSubject(subjectForRequestInitialDataLoad);
        log.info("RequestDataLoad email sent to {}", emailPayLoad.getTo());
        emailPayLoad.setMessageDisplay(messageDisplayForInstitution(fileNameWithPath));
        return emailPayLoad;
    }

    public String emailIdTo(String institution) {
        return propertyUtil.getPropertyByInstitutionAndKey(institution, PropertyKeyConstants.ILS.ILS_EMAIL_REQUEST_INITIAL_LOAD_TO);
    }

    public String messageDisplayForInstitution(String fileNameWithPath){
        return "A report containing barcodes that have requests in GFA but which are not in SCSB has been created and can be found at the FTP location "+fileNameWithPath;
    }

}
