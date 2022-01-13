package org.recap.ils.protocol.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;


/**
 * Created by rajeshbabuk on 9/12/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ProblemType",
        "ProblemDetail"
})
@Data
public class Problem {
    @JsonProperty("ProblemType")
    private String problemType;
    @JsonProperty("ProblemDetail")
    private String problemDetail;
}
