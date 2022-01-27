package org.recap.model.response;

import lombok.Data;

import lombok.EqualsAndHashCode;
import org.recap.model.AbstractResponseItem;

/**
 * Created by sudhishk on 16/12/16.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ItemHoldResponse extends AbstractResponseItem {

    private boolean available;
    private String transactionDate;
    private String institutionID;
    private String patronIdentifier;
    private String titleIdentifier;
    private String expirationDate;
    private String pickupLocation;
    private String queuePosition;
    private String bibId;
    private String isbn;
    private String lccn;
    private String trackingId;
    private String jobId;
    private String updatedDate;
    private String createdDate;

}
