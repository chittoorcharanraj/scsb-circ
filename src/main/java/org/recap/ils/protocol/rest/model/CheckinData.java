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
        "jobId",
        "processed",
        "success",
        "updatedDate",
        "createdDate",
        "itemBarcode"
})
@Data
public class CheckinData {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("jobId")
    private String jobId;
    @JsonProperty("processed")
    private Boolean processed;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("updatedDate")
    private Object updatedDate;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("itemBarcode")
    private String itemBarcode;
}
