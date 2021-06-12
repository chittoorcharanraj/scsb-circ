package org.recap.model.response;

import lombok.Getter;
import lombok.Setter;
import org.recap.model.AbstractResponseItem;

import java.util.List;

/**
 * Created by sudhishk on 26/12/16.
 */
@Getter
@Setter
public class PatronInformationResponse extends AbstractResponseItem {
    String patronIdentifier = "";
    String patronName = "";
    String Email = "";
    String BirthDate;
    String Phone;
    String PermanentLocation;
    String PickupLocation;
    int ChargedItemsCount;
    int ChargedItemsLimit;
    String FeeLimit;
    String FeeType;
    int HoldItemsCount;
    int HoldItemsLimit;
    int UnavailableHoldsCount;
    int FineItemsCount;
    String FeeAmount;
    String HomeAddress;
    List<String> Items;
    String ItemType;
    int OverdueItemsCount;
    int OverdueItemsLimit;
    String PacAccessType;
    String PatronGroup;
    String PatronType;
    String DueDate;
    String ExpirationDate;
    String Status;

}
