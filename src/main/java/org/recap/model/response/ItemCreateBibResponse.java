package org.recap.model.response;

import lombok.Getter;
import lombok.Setter;
import org.recap.model.AbstractResponseItem;

/**
 * Created by sudhishk on 16/12/16.
 */
@Getter
@Setter
public class ItemCreateBibResponse extends AbstractResponseItem {

    private String bibId;
    private String itemId;

}
