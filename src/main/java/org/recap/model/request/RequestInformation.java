package org.recap.model.request;

import lombok.Getter;
import lombok.Setter;
import org.recap.model.request.ItemRequestInformation;
import org.recap.model.response.ItemInformationResponse;

/**
 * Created by sudhishk on 9/11/17.
 */
@Setter
@Getter
public class RequestInformation {
    private ItemRequestInformation itemRequestInfo;
    private ItemInformationResponse itemResponseInformation;

}
