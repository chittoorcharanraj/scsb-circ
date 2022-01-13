package org.recap.ils.protocol.rest.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;


/**
 * Created by rajeshbabuk on 14/7/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "itemBarcode"
})
@Data
public class RefileRequest {
    @JsonProperty("itemBarcode")
    private String itemBarcode;
}
