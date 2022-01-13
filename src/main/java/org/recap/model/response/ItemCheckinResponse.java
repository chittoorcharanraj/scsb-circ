package org.recap.model.response;

import lombok.Data;

import lombok.EqualsAndHashCode;
import org.recap.model.AbstractResponseItem;

/**
 * Created by sudhishk on 16/12/16.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ItemCheckinResponse extends AbstractResponseItem {

    private boolean alert;
    private boolean magneticMedia;
    private boolean resensitize;
    private String transactionDate;
    private String institutionID;
    private String patronIdentifier;
    private String titleIdentifier;
    private String dueDate;
    private String feeType ;
    private String securityInhibit;
    private String currencyType;
    private String feeAmount;
    private String mediaType;
    private String bibId;
    private String isbn;
    private String lccn;
    private String permanentLocation;
    private String sortBin;
    private String collectionCode;
    private String callNumber;
    private String destinationLocation;
    private String alertType;
    private String holdPatronId;
    private String holdPatronName;
    private String jobId;
    private boolean processed;
    private String updatedDate;
    private String createdDate;

}
