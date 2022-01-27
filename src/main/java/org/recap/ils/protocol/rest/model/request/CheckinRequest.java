package org.recap.ils.protocol.rest.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;


/**
 * Created by rajeshbabuk on 8/12/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "itemBarcode"
})
@Data
public class CheckinRequest {
    @JsonProperty("itemBarcode")
    private String itemBarcode;
}
