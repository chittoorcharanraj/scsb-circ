package org.recap.ils.protocol.rest.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import org.recap.ils.protocol.rest.model.DebugInfo;
import org.recap.ils.protocol.rest.model.RefileData;

import java.util.List;

/**
 * Created by rajeshbabuk on 14/7/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
        "count",
        "statusCode",
        "debugInfo"
})
@Data
public class RefileResponse {

    @JsonProperty("data")
    private RefileData data;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("statusCode")
    private Integer statusCode;
    @JsonProperty("debugInfo")
    private List<DebugInfo> debugInfo = null;
}
