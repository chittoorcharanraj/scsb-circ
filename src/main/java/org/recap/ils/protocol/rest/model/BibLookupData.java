package org.recap.ils.protocol.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;


/**
 * Created by Suresh.s .
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bibId",
        "title",
        })
@Data
public class BibLookupData {
    @JsonProperty("mms_id")
    private Object bibId;
    @JsonProperty("title")
    private Object title;
}
