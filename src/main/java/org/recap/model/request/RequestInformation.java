package org.recap.model.request;

import lombok.Data;
import org.recap.model.response.ItemInformationResponse;

/**
 * Created by sudhishk on 9/11/17.
 */
@Data
public class RequestInformation {
    private ItemRequestInformation itemRequestInfo;
    private ItemInformationResponse itemResponseInformation;

}
