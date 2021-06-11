package org.recap.model.response;

import lombok.Getter;
import lombok.Setter;
import org.recap.model.AbstractResponseItem;

/**
 * Created by sudhishk on 16/12/16.
 */
@Getter
@Setter
public class ItemCheckoutResponse extends AbstractResponseItem {

    private boolean renewal;
    private boolean magneticMedia;
    private boolean desensitize;
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
    private String jobId;
    private boolean processed;
    private String updatedDate;
    private String createdDate;

}
