package org.recap.ils.protocol.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;


/**
 * Created by rajeshbabuk on 8/12/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "updatedDate",
        "createdDate",
        "jobId",
        "trackingId",
        "owningInstitutionId",
        "itemBarcode",
        "patronBarcode"
})
@Data
public class CancelHoldData {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("updatedDate")
    private Object updatedDate;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("jobId")
    private String jobId;
    @JsonProperty("trackingId")
    private String trackingId;
    @JsonProperty("owningInstitutionId")
    private String owningInstitutionId;
    @JsonProperty("itemBarcode")
    private String itemBarcode;
    @JsonProperty("patronBarcode")
    private String patronBarcode;
}
