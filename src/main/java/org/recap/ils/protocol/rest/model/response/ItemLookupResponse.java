package org.recap.ils.protocol.rest.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import org.recap.ils.protocol.rest.model.BibLookupData;
import org.recap.ils.protocol.rest.model.ItemLookupData;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bibLookupData",
        "itemLookupData"
 })

@Data
public class ItemLookupResponse {

    @JsonProperty("bib_data")
    private BibLookupData bibLookupData;
    @JsonProperty("item_data")
    private ItemLookupData itemLookupData;

}
