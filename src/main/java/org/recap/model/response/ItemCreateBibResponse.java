package org.recap.model.response;

import lombok.Data;

import lombok.EqualsAndHashCode;
import org.recap.model.AbstractResponseItem;

/**
 * Created by sudhishk on 16/12/16.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ItemCreateBibResponse extends AbstractResponseItem {

    private String bibId;
    private String itemId;

}
