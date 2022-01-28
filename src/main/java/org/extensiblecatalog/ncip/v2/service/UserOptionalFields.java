//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import java.util.GregorianCalendar;
import java.util.List;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UserOptionalFields {
    protected NameInformation nameInformation;
    protected List<UserAddressInformation> userAddressInformations;
    protected GregorianCalendar dateOfBirth;
    protected List<UserLanguage> userLanguages;
    protected List<UserPrivilege> userPrivileges;
    protected List<BlockOrTrap> blockOrTraps;
    protected List<UserId> userIds;

    public UserOptionalFields() {
    }

    public NameInformation getNameInformation() {
        return this.nameInformation;
    }

    public void setNameInformation(NameInformation nameInformation) {
        this.nameInformation = nameInformation;
    }

    public List<UserAddressInformation> getUserAddressInformations() {
        return this.userAddressInformations;
    }

    public UserAddressInformation getUserAddressInformation(int index) {
        return (UserAddressInformation)this.userAddressInformations.get(index);
    }

    public void setUserAddressInformations(List<UserAddressInformation> userAddressInformations) {
        this.userAddressInformations = userAddressInformations;
    }

    public GregorianCalendar getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<UserLanguage> getUserLanguages() {
        return this.userLanguages;
    }

    public UserLanguage getUserLanguage(int index) {
        return (UserLanguage)this.userLanguages.get(index);
    }

    public void setUserLanguages(List<UserLanguage> userLanguages) {
        this.userLanguages = userLanguages;
    }

    public List<UserPrivilege> getUserPrivileges() {
        return this.userPrivileges;
    }

    public UserPrivilege getUserPrivilege(int index) {
        return (UserPrivilege)this.userPrivileges.get(index);
    }

    public void setUserPrivileges(List<UserPrivilege> userPrivileges) {
        this.userPrivileges = userPrivileges;
    }

    public List<BlockOrTrap> getBlockOrTraps() {
        return this.blockOrTraps;
    }

    public BlockOrTrap getBlockOrTrap(int index) {
        return (BlockOrTrap)this.blockOrTraps.get(index);
    }

    public void setBlockOrTraps(List<BlockOrTrap> blockOrTraps) {
        this.blockOrTraps = blockOrTraps;
    }

    public List<UserId> getUserIds() {
        return this.userIds;
    }

    public UserId getUserId(int index) {
        return (UserId)this.userIds.get(index);
    }

    public void setUserIds(List<UserId> userIds) {
        this.userIds = userIds;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
